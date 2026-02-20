FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/devops-demo.jar /app/devops-demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "devops-demo.jar"]