# Avro 
This repository contains everything for the August 2019 Kafka Meetup talk titles:
> Adding Avro to your Kafka streams to meet your messaging needs

## Requirements
* Docker
* [Confluent Platform](https://www.confluent.io/download/)
 * Techincally you don't need this (you can build it yourself) - this is just much simpler

## What's in this dir?
Most direcotries will be an example that can be run as a Docker container.  Run these with the `-network host` argument and you will not have to worry about connecting things.

**Important:** These containers are run with the assumption that you have downloaded the Confluent Platform and are running the `example/cp-all-in-one`.

* perl_consumer - Perl Example