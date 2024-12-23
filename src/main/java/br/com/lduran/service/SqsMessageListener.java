package br.com.lduran.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;

@Slf4j
@Service
public class SqsMessageListener
{
	private final SqsClient sqsClient;

	@Value("${sqs.delete.message:false}") // Define o comportamento padrão (apagar ou não)
	private boolean deleteMessage;

	public SqsMessageListener(SqsClient sqsClient)
	{
		this.sqsClient = sqsClient;
	}

	public void listenToMessages(String queueUrl)
	{
		ReceiveMessageRequest receiveRequest = ReceiveMessageRequest.builder()
				.queueUrl(queueUrl)
				.maxNumberOfMessages(10)
				.waitTimeSeconds(20) // Long polling
				.build();

		List<Message> messages = sqsClient.receiveMessage(receiveRequest).messages();
		for (Message message : messages)
		{
			log.info("Received message: " + message.body());
			// Process the message here

			// Apaga a mensagem se configurado para tal
			if (deleteMessage)
			{
				deleteMessage(queueUrl, message.receiptHandle());
			}
		}
	}

	private void deleteMessage(String queueUrl, String receiptHandle)
	{
		DeleteMessageRequest deleteRequest = DeleteMessageRequest.builder()
				.queueUrl(queueUrl)
				.receiptHandle(receiptHandle)
				.build();

		sqsClient.deleteMessage(deleteRequest);
		log.info("Message deleted successfully.");
	}
}
