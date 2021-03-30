FROM openjdk:8-jdk
RUN apt-get update
RUN apt-get install -y maven
COPY /var/lib/jenkins/workspace/RiskMeter/RiskMeter/pom.xml /usr/local/service/pom.xml
COPY /var/lib/jenkins/workspace/RiskMeter/RiskMeter /usr/local/service/src
WORKDIR /usr/local/service
RUN mvn package