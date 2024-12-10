FROM openjdk:17-jdk-slim
VOLUME /tmp
EXPOSE 8080
COPY target/ChecksumWebApp-0.0.1-SNAPSHOT.jar app.jar
COPY /data /data
ENTRYPOINT ["java","-jar","/app.jar"]
