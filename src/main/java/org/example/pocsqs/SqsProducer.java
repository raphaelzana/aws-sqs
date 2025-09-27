package org.example.pocsqs;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsProducer {

    private final SqsClient sqsClient;

    public SqsProducer(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    public void sendMessage(String queueUrl, String message) {
        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .build();

        sqsClient.sendMessage(request);
        System.out.println("Mensagem enviada: " + message);
    }
}
