FROM maven:3.6-jdk-8
MAINTAINER Erik Tank <erik.tank@ticketmaster.com>


WORKDIR /code
COPY code/src /code/src
COPY code/pom.xml /code/pom.xml

RUN mvn compile

RUN echo 'alias ll="ls -al"' >> ~/.bashrc;

CMD mvn -q exec:java -Dexec.mainClass=com.jundy.avro.App