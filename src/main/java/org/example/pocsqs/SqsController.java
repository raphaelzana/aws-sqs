package org.example.pocsqs;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
public class SqsController {

    private final SqsProducer sqsProducer;


    public SqsController(SqsProducer sqsProducer) {
        this.sqsProducer = sqsProducer;
    }

    // Envia uma mensagem para a fila SQS
    @PostMapping("/send")
    public String sendMessage(
            @RequestParam String message) {

        String queueUrl = "https://sqs.us-east-1.amazonaws.com/yourParicularUrl";
        sqsProducer.sendMessage(queueUrl, message);
        return "Mensagem enviada com sucesso para a fila!";
    }
}
