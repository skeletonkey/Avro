# Avro

This repository contains everything for an AVRO sandbox that goes along with the talk titled:
> Adding Avro to your Kafka streams to meet your messaging needs

Slides to the presentation are available at [Slide Share](https://www.slideshare.net/ErikTank/avro-237190790)

## Purpose

This repo contains everything that is needed to play around with Avro.

There is a producer that writes to a topic using an Avro schema and at least one consumer of that topic.

The schema can be changed to test out how those changes affect the entire eco-system.

## Requirements

* Docker
* [Confluent Platform](https://www.confluent.io/download/)
  * Technically you don't need this (you can build it yourself) - this is just much simpler
* This repo cloned locally

## To Follow Along

* Download the Confluent Platform and extract it
  * Examples in this repo are using: [https://github.com/confluentinc/cp-all-in-one](https://github.com/confluentinc/cp-all-in-one)
* Go to `cp-all-in-one` directory  of the Confluent Platform
* Run `docker-compose up -d --build`
  * Make sure to follow instructions to up your Docker memory to at least 10 GB
  * If you want to stop everything simply run `docker-compose down` in that directory (or manually stop all docker instances)
* Go to [http://localhost:9021/](http://localhost:9021/) and create a topic named `config_user_rules`
  * First time running the build command it may take several minutes for the interface to come up
  * If interface doesn't come up (or acts strangely) make sure that you've increased your Docker memory
* Use the `config-manager` (See `What's in this repo?` section) to publish to that topic

## What's in this repo

Each directory should have its own README.md file talking about and showing how to run each service.

Most directories will be an example that can be run as a Docker container.  Run these with the `--network host` argument and you will not have to worry about connecting things.

**Important:** These containers are run with the assumption that you have downloaded the Confluent Platform and are running the `cp-all-in-one`.

* cli-consumer - Kafka Command Line Interface (Go)
* config-manager - **producer** to the Kafka stream
* java-consumer - Java Consumer Example
