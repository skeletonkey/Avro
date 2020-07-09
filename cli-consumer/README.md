# CLI Consumer

## Build & Develop

### Build

```shell
docker build --rm=false -t cli_consumer .
```

### Run

#### Interactive

This will start the container and drop you at a Bash prompt.

```shell
docker run -it --rm --name my_cli_consumer --network host cli_consumer /bin/bash
```

Once at the command prompt you can use the CLI by running `kafka-cli`

#### Daemon

```shell
docker run -d --rm --name my_cli_consumer --network host cli_consumer
```

This will run the consumer reading from `config_user_rules` topic

## Consume from Kafka Topic

It's assumed that Confluent Platform is running using `cp-all-in-one`.

Also, that there's a topic named `config_user_rules`.

Choose how you want to run the container from the Run section.

If you've chosen the Daemon method you'll need to watch it's 'logs' to see what is going on with it:

```shell
docker logs -f my_cli_consumer
```
