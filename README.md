# 🌟 SpringBootLocalStack

🎯 **Executando microsserviços AWS localmente via LocalStack**

---

## 🔗 Links Relevantes
- 📖 [Artigo: Java + AWS Lambda: montando um ambiente de desenvolvimento local com LocalStack](https://thomsdacosta.medium.com/java-aws-lambda-montando-um-ambiente-de-desenvolvimento-local-com-localstack-a845624bee40)

---

## 🧭 Índice
- [Criando e Configurando um Projeto do Zero](#-criando-e-configurando-um-projeto-do-zero) 
- [Usando AWS Secrets Manager](#-usando-aws-secrets-manager)
- [AWS SQS - Como Publicar e Consumir Mensagens](#-aws-sqs-como-publicar-e-consumir-mensagens)
- [Usando o AWS SQS](#usando-o-aws-sqs)
- [Usando o AWS SNS](#usando-o-aws-sns)
- [Efetuando Operações com AWS S3](#efetuando-operacoes-om-aws-s3)
- [Como criar um CRUD com Spring Boot e Java 21](#como-criar-um-crud-com-spring-boot-e-java-21)
- [Material de Apoio](#-material-de-apoio)
- [Versões das Libs](#-versões-das-libs)

---

## 🎥 Criando e Configurando um Projeto do Zero
### **1. Spring Boot + LocalStack: criando e configurando um projeto do ZERO**
🔗 [Assista o vídeo](https://youtu.be/Vlmjw5nifOo?si=cVn6-9pNSSwNaR5D)
| Tempo     | Tópico                                                                                   |
|-----------|------------------------------------------------------------------------------------------|
| 00:00     | Introdução                                                                               |
| 00:31     | O que é o Spring Cloud?                                                                  |
| 01:31     | Qual versão usar do Spring Cloud em seu projeto Spring Boot?                             |
| 03:01     | Qual versão usar do Spring Cloud AWS em seu projeto Spring Boot?                         |
| 03:41     | Criando o projeto com Spring Initializr                                                  |
| 05:46     | Gerando o projeto e descompactando                                                       |
| 06:19     | Abrindo o projeto na IDE                                                                 |
| 08:15     | Incluindo as dependências do Spring Cloud e Spring Cloud AWS                             |
| 11:16     | Incluindo a dependência do AWS Parameter Store                                           |
| 12:45     | Criando o arquivo `bootstrap.yml`                                                        |
| 15:20     | Ajustando o `application.properties`                                                     |
| 15:53     | Incluindo o profile localstack para a inicialização do Spring Boot                       |
| 16:55     | O que é um profile no Spring Boot?                                                       |
| 17:52     | Criando o `docker-compose.yml` do LocalStack                                             |
| 19:09     | Inicializando o LocalStack                                                               |
| 21:03     | Criando a configuração do Parameter Store no LocalStack                                  |
| 24:44     | Executando a aplicação                                                                   |
| 26:55     | Criando a classe de configuração                                                         |
| 29:31     | Criando a classe Controller                                                              |
| 32:33     | Executando a aplicação para o teste final                                                |
| 33:24     | Executando o teste no Insomnia                                                           |
| 34:43     | **EASTER EGG!!!!**                                                                       |

---

## 📽 Usando AWS Secrets Manager
### **2. Spring Boot + LocalStack: usando AWS Secrets Manager**
🔗 [Assista o vídeo](https://youtu.be/JhWFD-4oQqQ?si=xohkG-_SBsAC2Frj)

| Tempo     | Tópico                                          |
|-----------|-------------------------------------------------|
| 00:00     | Introdução                                      |
| 00:32     | O que é o AWS Secrets Manager?                  |
| 00:50     | Configurando o `pom.xml` e `bootstrap.yml`      |
| 02:23     | Criando o Secrets Manager com AWS CLI           |
| 04:25     | Criando a classe `Configuration` e `Controller` |
| 06:15     | Executando a aplicação                          |
| 07:08     | Testando no Insomnia                            |
| 08:15     | **12 Fatores**                                  |

---

## 📽 AWS SQS - Como Publicar e Consumir Mensagens
### **3. AWS SQS: Como publicar e consumir mensagens com Spring Cloud AWS**
🔗 [Assista o vídeo](https://youtu.be/56_F59cIT8M?si=wx0rlAz7Thn0t9wW)

| Tempo     | Tópico                                |
|-----------|---------------------------------------|
| 00:00     | Introdução                            |
| 00:57     | Instalando a LocalStack e AWS CLI     |
| 01:30     | Iniciando o projeto                   |
| 03:15     | Criando a fila AWS SQS                |
| 03:47     | Configurando o Spring Cloud AWS       |
| 06:11     | Configurando o `SqsAsyncClient`       |
| 08:38     | Criando um Consumer do AWS SQS        |
| 13:33     | Criando um Producer do AWS SQS        |
| 16:52     | Conclusão                             |

---

## 📽 Usando o AWS SQS
### **4. Spring Boot + LocalStack: usando o AWS SQS**
🔗 [Assista o vídeo](https://youtu.be/cAcPjO5eTY0?si=FBRhYZoPZm5irh_1)

| Tempo     | Tópico                                                      |
|-----------|-------------------------------------------------------------|
| 00:00     | Introdução                                                  |
| 00:16     | O que é o AWS SQS?                                          |
| 01:33     | Configurando a aplicação                                    |
| 02:45     | Criando a fila no SQS com AWS CLI                           |
| 03:29     | Enviando mensagem para o SQS com AWS CLI                    |
| 04:15     | Consumindo a mensagem do SQS com AWS CLI                    |
| 05:14     | Código Fonte                                                |
| 06:06     | Consumindo mensagem do SQS através de um listener           |
| 07:49     | Enviando uma mensagem através do código fonte               |
| 08:55     | Classe Controller                                           |
| 09:50     | Inicializando a aplicação                                   |
| 10:36     | Executando no Insomnia                                      |
| 11:44     | Enviando mensagem pela aplicação e consumindo pelo AWS CLI  |
| 13:30     | Arquitetura Orientada a Eventos                             |

---

## 📽 Usando o AWS SNS
### **5. Spring Boot + LocalStack: usando o AWS SNS**
🔗 [Assista o vídeo](https://youtu.be/BeHXJeIgTxw?si=XwgS12enHFgT6gn5)

| Tempo     | Tópico                       |
|-----------|------------------------------|
| 00:00     | Introdução                   |
| 00:42     | O que é o AWS SNS?           |
| 01:44     | Arquitetura da Aplicação     |
| 02:20     | Diferença entre o SQS e SNS  |
| 03:56     | Configuração da aplicação    |
| 04:39     | Criando o tópico com AWS CLI |
| 07:41     | Inicializando a aplicação    |
| 08:38     | Testando a aplicação         |
| 10:36     | Formato da mensagem do SNS   |
| 11:59     | Código fonte da aplicação    |

-----

## 📽 Efetuando Operações com AWS S3
### **6. Spring Boot + LocalStack: efetuando operações com AWS S3**
🔗 [Assista o vídeo](https://youtu.be/yVaDgaV6AL8?si=n3Znz4t5EeGoz_U1)

| Tempo     | Tópico                                          |
|-----------|-------------------------------------------------|
| 00:00     | Introdução                                      |
| 00:30     | O que é o AWS S3?                               |
| 01:03     | Configuração da aplicação                       |
| 02:54     | Criando bucket com AWS CLI                      |
| 04:31     | Código fonte da aplicação                       |
| 05:16     | Classe ResourceLoader e ResourcePatternResolver |
| 07:49     | Salvando um arquivo no S3                       |
| 10:33     | Pesquisando arquivos em um bucket               |
| 13:10     | Mostrar o conteúdo de um arquivo                |
| 15:14     | Código da classe Controller                     |
| 19:42     | Exibindo o conteúdo do arquivo                  |
| 21:23     | Executando testes no Insomnia                   |
| 22:39     | Exibindo os arquivos no bucket com AWS CLI      |
| 23:55     | Concluindo os testes no Insomnia                |
-----

## 📽 Como criar um CRUD com Spring Boot e Java 21
### **7. AWS DynamoDB: Como criar um CRUD com Spring Boot e Java 21**
🔗 [Assista o vídeo](https://youtu.be/qxSeffy6Nr4?si=5vjHXwMA9FVwNyHG)

| Tempo     | Tópico                                          |
|-----------|-------------------------------------------------|
| 00:00     | Introdução                                      |
| 00:35     | Conhecer o projeto de hoje                      |
| 01:25     | LocalStack e AWS CLI                            |
| 01:45     | Iniciar o projeto                               |
| 02:38     | Spring Cloud AWS                                |
| 04:20     | Configurando o DynamoDB Client                  |
| 06:32     | Configurando a entidade do DynamoDb             |
| 09:09     | Criando a funcionalidade de 'CADASTRO'          |
| 18:27     | Criando a funcionalidade de 'LISTAGEM'          |
| 22:40     | Criando a funcionalidade de 'CONSULTA'          |
| 26:02     | Criando a funcionalidade de 'ATUALIZAÇÃO'       |
| 28:32     | Criando a funcionalidade de 'DELEÇÃO'           |
| 29:42     | Conclusão                                       |

---

## 📂 Material de Apoio
- [GitHub](https://github.com/thomasdacosta/spring-boot-localstack)
- [Spring Initializr](https://start.spring.io/)
- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [Spring Cloud AWS](https://spring.io/projects/spring-cloud-aws) 
- [Documentação Oficial Spring Cloud AWS](https://docs.awspring.io/spring-cloud-aws/docs/2.4.2/reference/html/index.html)

---

## 📋 Versões das Libs
- **Java**: 11  
- **Spring Boot**: 2.7.8  
- **Spring Cloud**: 2021.0.5  
- **Spring Cloud AWS**: 2.4.2  

---

## 🛠 Como Contribuir
1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nome-da-feature`).
3. Commit suas mudanças (`git commit -m 'Adicionei uma nova feature'`).
4. Envie para o branch principal (`git push origin feature/nome-da-feature`).
5. Abra um Pull Request.

---

🌟 **Obrigado por visitar! Não esqueça de deixar uma ⭐ se este repositório te ajudou!**

