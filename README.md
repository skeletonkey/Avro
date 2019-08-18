# Avro 
This repository contains everything for the August 2019 Kafka Meetup talk titles:
> Adding Avro to your Kafka streams to meet your messaging needs

## Requirements
* Docker
* [Confluent Platform](https://www.confluent.io/download/)
	* Techincally you don't need this (you can build it yourself) - this is just much simpler

## To Follow Along
* Download the Confluent Platform and extract it
* Go to `examples/cp-all-in-one` directory  of the Confluent Platform
* Run `docker-compose up -d --build`
	* Make sure to follow instructions to up your Docker memory to at least 10
	* If you want to stop everything simply run `docker-compose down` in that directory (or stop all docker instances)
* Go to `http://localhost:9021/` and create a topic named `config_user_rules`
* Use the `config-manager` to publish to that topic

## What's in this dir?
Each directory should have its own README.md file talking about and showing how to run each service.

Most direcotries will be an example that can be run as a Docker container.  Run these with the `-network host` argument and you will not have to worry about connecting things.

**Important:** These containers are run with the assumption that you have downloaded the Confluent Platform and are running the `example/cp-all-in-one`.

* config-manager - **producer** to the kafka stream
* java-consumer - Java Consumer Example