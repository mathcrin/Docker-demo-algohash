# build de l'image avec maven
FROM maven:3.8.5-openjdk-17-slim as build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app
RUN mvn -X clean package
CMD sh

# deploiement de l'application dans une image openjdk
FROM openjdk:17-jdk-slim
VOLUME /tmp
EXPOSE 8080
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
COPY /data /usr/local/lib/data
WORKDIR /usr/local/lib
ENTRYPOINT ["java","-jar","./app.jar"]
