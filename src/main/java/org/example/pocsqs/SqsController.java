package org.example.pocsqs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
public class SqsController {

    private final SqsProducer sqsProducer;

    @Value("${aws.sqs.queue-url}")
    private String queueUrl;


    public SqsController(SqsProducer sqsProducer) {
        this.sqsProducer = sqsProducer;
    }

    // Envia uma mensagem para a fila SQS
    @PostMapping("/send")
    public String sendMessage(
            @RequestParam String message) {

        sqsProducer.sendMessage(queueUrl, message);
        return "Mensagem enviada com sucesso para a fila!";
    }
}
