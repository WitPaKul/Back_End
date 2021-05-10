### STAGE 1: Build ###
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /
VOLUME /tmp
COPY src /src
RUN mvn clean install

### STAGE 2: Run ###
FROM openjdk:11-slim
EXPOSE 5000
COPY --from=build /target/WitPaKul_Back_End-0.0.1-SNAPSHOT.jar WitPaKul_Back_End-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","WitPaKul_Back_End-0.0.1-SNAPSHOT.jar"]