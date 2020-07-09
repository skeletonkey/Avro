FROM golang:1.14-buster
LABEL MAINTAINER="Erik Tank <erik.tank@ticketmaster.com>"

ENV GOPATH=/go
ENV PATH=$PATH:/go/bin

RUN go get github.com/shafreeck/kafka-cli

RUN echo 'alias ll="ls -al"' >> ~/.bashrc;
RUN echo '$GOPATH/bin/kafka-cli consume config_user_rules' >> /usr/local/bin/run_consumer
RUN chmod 755 /usr/local/bin/run_consumer

CMD run_consumer