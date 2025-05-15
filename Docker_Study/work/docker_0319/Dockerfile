FROM openjdk:17
#FROM --platform=linux/amd64 openjdk:17-alpine

ARG JAR_FILE=/build/libs/docker_0319-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /doc_0319.jar

ENTRYPOINT [ "java", "-jar", "/doc_0319.jar" ]