package br.com.lduran.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Slf4j
@Service
public class SnsNotificationService
{
	private final SnsClient snsClient;

	@Value("${sns.topic.arn}")
	private String topicArn;

	public SnsNotificationService(SnsClient snsClient)
	{
		this.snsClient = snsClient;
	}

	public void sendNotification(String subject, String message, String topicArnOverride)
	{
		String targetTopicArn = (topicArnOverride != null) ? topicArnOverride : topicArn;

		PublishRequest request = PublishRequest.builder().topicArn(targetTopicArn).subject(subject).message(message).build();

		PublishResponse response = snsClient.publish(request);
		log.info("Message sent to SNS with ID: " + response.messageId());
	}
}
