FROM openjdk:17
LABEL org.opencontainers.image.authors="com.geekbrains"
ADD target/*.jar front-service.jar
EXPOSE 8190
ENTRYPOINT ["java", "-jar", "front-service.jar"]
