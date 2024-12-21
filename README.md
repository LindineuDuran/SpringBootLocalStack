# SpringBootLocalStack
 ### Executando microsserviços AWS localmente via LocalStack
 
 - [Java + AWS Lambda: montando um ambiente de desenvolvimento local com LocalStack](https://thomsdacosta.medium.com/java-aws-lambda-montando-um-ambiente-de-desenvolvimento-local-com-localstack-a845624bee40)
- [Spring Boot + LocalStack: criando e configurando um projeto do ZERO](https://youtu.be/Vlmjw5nifOo?si=cVn6-9pNSSwNaR5D)
### Capítulos:
- 00:00 Introdução
- 00:31 O que é o Spring Cloud?
- 01:31 Qual versão usar do Spring Cloud em seu projeto Spring Boot?
- 03:01 Qual versão usar do Spring Cloud AWS em seu projeto Spring Boot?
- 03:41 Criando o projeto com Spring Initializr
- 05:46 Gerando o projeto e descompactando
- 06:19 Abrindo o projeto na IDE
- 08:15 Incluindo as dependências do Spring Cloud e Spring Cloud AWS
- 11:16 Incluindo a dependência do AWS Parameter Store
- 12:45 Criando o arquivo bootstrap.yml
- 15:20 Ajustando o application.properties
- 15:53 Incluindo o profile localstack para a inicialização do Spring Boot
- 16:55 O que é um profile no Spring Boot?
- 17:52 Criando o docker-compose.yml do LocalStack
- 19:09 Inicializando o LocalStack
- 21:03 Criando a configuração do Parameter Store no LocalStack
- 24:44 Executando a aplicação
- 26:55 Criando a classe de configuração
- 29:31 Criando a classe Controller
- 32:33 Executando a aplicação para o teste final
- 33:24 Executando o teste no Insomnia
- 34:43 EASTER EGG!!!!

- [Spring Boot + LocalStack: usando AWS Secrets Manager](https://youtu.be/JhWFD-4oQqQ?si=xohkG-_SBsAC2Frj)
### Capítulos:
- 00:00 Introdução
- 00:32 O que é o AWS Secrets Manager?
- 00:50 Configurando o pom.xml e o bootstrap.yml
- 02:23 Criando o Secrets Manager com AWS CLI
- 04:25 Criando a classe de Configuration e Controller
- 06:15 Executando a aplicação
- 07:08 Executar no Insomnia
- 08:15 12 Fatores

- [GitHub](https://github.com/thomasdacosta/spring-boot-localstack)
- [Spring Initializr](https://start.spring.io/)
- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [Spring Cloud AWS](https://spring.io/projects/spring-cloud-aws#overview); (https://github.com/awspring/spring-cloud-aws); (https://docs.awspring.io/spring-cloud-aws/docs/2.4.2/reference/html/index.html)

#### Versões das libs:
- Java 11
- Spring Boot 2.7.8
- Spring Cloud 2021.0.5
- Spring Cloud AWS 2.4.2