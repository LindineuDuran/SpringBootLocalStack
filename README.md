# 🌟 SpringBootLocalStack

🎯 **Executando microsserviços AWS localmente via LocalStack**

---

## 🔗 Links Relevantes
- 📖 [Artigo: Java + AWS Lambda: montando um ambiente de desenvolvimento local com LocalStack](https://thomsdacosta.medium.com/java-aws-lambda-montando-um-ambiente-de-desenvolvimento-local-com-localstack-a845624bee40)

---

## 🧭 Índice
- [Criando e Configurando um Projeto do Zero](#-criando-e-configurando-um-projeto-do-zero) 
- [Usando AWS Secrets Manager](#-usando-aws-secrets-manager)
- [Material de Apoio](#-material-de-apoio)
- [Versões das Libs](#-versões-das-libs)

---

## 🎥 Criando e Configurando um Projeto do Zero
### **1. Spring Boot + LocalStack: criando e configurando um projeto do ZERO**
🔗 [Assista aqui](https://youtu.be/Vlmjw5nifOo?si=cVn6-9pNSSwNaR5D)
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
🔗 [Assista aqui](https://youtu.be/JhWFD-4oQqQ?si=xohkG-_SBsAC2Frj)

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

