#FROM python:3.7-buster
FROM python:2.7-buster
MAINTAINER Erik Tank <erik.tank@ticketmaster.com>


WORKDIR /code

RUN echo 'alias ll="ls -al"' >> ~/.bashrc;

COPY avro_python.tgz /code/avro_python.tgz
RUN tar -zxf avro_python.tgz; rm avro_python.tgz; cd py; python setup.py install; cd /code; rm -fr py;
RUN pip install confluent-kafka;
