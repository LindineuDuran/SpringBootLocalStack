package br.com.lduran.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

@Slf4j
@Component
public class SqsMessageProducer
{
	private final SqsClient sqsClient;

	@Value("${sqs.queue.name}")
	private String queueName;

	public SqsMessageProducer(SqsClient sqsClient)
	{
		this.sqsClient = sqsClient;
	}

	public void sendMessage(String message)
	{
		// Recupera a URL da fila a partir do nome
		String queueUrl = sqsClient.getQueueUrl(builder -> builder.queueName(queueName)).queueUrl();

		// Monta a requisição para enviar a mensagem
		SendMessageRequest request = SendMessageRequest.builder().queueUrl(queueUrl).messageBody(message).build();

		// Envia a mensagem e captura a resposta
		SendMessageResponse response = sqsClient.sendMessage(request);

		// Log ou tratamento adicional
		log.info("Mensagem enviada com sucesso. Message ID: " + response.messageId());
	}
}