FROM java:8-jdk-alpine
MAINTAINER heloise
COPY target/rewardService-0.0.1-SNAPSHOT.jar rewardService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/rewardService-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080