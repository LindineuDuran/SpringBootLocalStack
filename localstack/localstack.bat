@echo off
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" --value "Hello World Parameter Store" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm get-parameter  --profile localstack --name "/config/spring-boot-localstack_localstack/helloWorld"
