# Usando uma imagem base do JDK 21
FROM openjdk:21-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR da aplicação para o container
COPY target/seu-projeto.jar app.jar

# Expõe a porta em que a aplicação vai rodar
EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
