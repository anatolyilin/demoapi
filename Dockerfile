FROM openjdk:8-jdk-alpine
VOLUME /tmp/apilog/
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080/tcp
