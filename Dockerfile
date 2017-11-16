FROM openjdk:8-jdk-alpine

MAINTAINER Lufuno_Maphwanya

ENV set_profile dev 

VOLUME /tmp

ADD build/libs/gradle-1.jar app.jar
 
RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

