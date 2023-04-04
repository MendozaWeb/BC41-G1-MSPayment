FROM openjdk:8-jdk-alpine
ADD target/*.jar /usr/share/ms-payment.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/usr/share/ms-payment.jar"]