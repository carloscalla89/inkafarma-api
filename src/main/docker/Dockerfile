FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER carlos.calla89@gmail.com
ADD persons-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]