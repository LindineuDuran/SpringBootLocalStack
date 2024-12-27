@echo off
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" --value "Hello World Parameter Store" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm get-parameter  --profile localstack --name "/config/spring-boot-localstack_localstack/helloWorld"

echo ### Criando Segredos no AWS Secret Manager do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"

aws --endpoint http://localhost:4566 --profile localstack secretsmanager get-secret-value --secret-id /secret/spring-boot-localstack_localstack

echo ### Criando Queue(Standard) no SQS do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name sqsHelloWorld

REM Lista Filas Criadas
REM aws --endpoint http://localhost:4566 --profile localstack sqs list-queues

echo ### Envia Mensagem para a Fila
REM aws --endpoint http://localhost:4566 --profile localstack sqs send-message --queue-url http://localhost:4566/000000000000/sqsHelloWorld --message-body "Hello World SQS!!!" --delay-seconds 1

REM Verifica Sucesso no Envio da Mensagem
REM aws --endpoint http://localhost:4566 --profile localstack sqs receive-message --queue-url http://localhost:4566/000000000000/sqsHelloWorld

echo ### Envia Mensagem para a Fila
REM aws --endpoint-url=http://localhost:4566 --profile localstack sqs send-message --queue-url=http://localhost:4566/000000000000/sqsHelloWorld --message-body "{'id': '123', 'content': 'Test message'}"

REM Verifica Sucesso no Envio da Mensagem
REM aws --endpoint http://localhost:4566 --profile localstack sqs receive-message --queue-url http://localhost:4566/000000000000/sqsHelloWorld

echo ### Criando Queue(Standard) no SNS do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name snsHelloWorld
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:sa-east-1:000000000000:snsHelloWorld --protocol sqs --notification-endpoint arn:aws:sqs:sa-east-1:000000000000:sqsHelloWorld

echo ### Criando Bucket no S3 do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack s3 mb s3://s3-helloworld

REM Confirmar a Criação do Bucket
REM aws --endpoint-url=http://localhost:4566 s3 ls

echo ### Cria Tabela PlayerHistory
aws --endpoint-url=http://localhost:4566 --profile localstack dynamodb create-table --table-name PlayerHistory --attribute-definitions AttributeName=player_id,AttributeType=S AttributeName=game_id,AttributeType=S --key-schema AttributeName=player_id,KeyType=HASH AttributeName=game_id,KeyType=RANGE --provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=5

echo ### Cria Tabela Books
aws --endpoint-url=http://localhost:4566 --profile localstack dynamodb create-table --table-name Books --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=5
