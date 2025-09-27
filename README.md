# poc-sqs

Aplicação simples que integra com Amazon SQS: envia mensagens via REST e consome-as de forma assíncrona.

## Configuração da fila
No application.properties, preencha:
- aws.sqs.queue-url=https://sqs.SE_REGION.amazonaws.com/SEU_ACCOUNT_ID/NOME_DA_FILA

Opcionalmente, use a variável de ambiente equivalente:
- AWS_SQS_QUEUE_URL

## Como rodar
- Build: mvn clean package
- Executar: mvn spring-boot:run