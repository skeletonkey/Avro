FROM maven:3.6-jdk-8
MAINTAINER Erik Tank <erik.tank@ticketmaster.com>

WORKDIR /code
COPY code/src /code/src
COPY code/pom.xml /code/pom.xml

RUN mvn compile

RUN echo 'alias ll="ls -al"' >> ~/.bashrc;
RUN echo 'mvn -q exec:java -Dexec.mainClass=com.jundy.avro.App' >> /usr/local/bin/run_consumer
RUN chmod 755 /usr/local/bin/run_consumer


CMD run_consumer