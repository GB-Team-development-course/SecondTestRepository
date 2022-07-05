FROM openjdk:17
LABEL org.opencontainers.image.authors="com.geekbrains"
ADD target/*.jar gateway.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "gateway.jar"]
