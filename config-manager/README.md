# Configuration Manager

## Build & Develop

### Build

```shell
docker build --rm=false -t config-manager .
```

### Develop

This will start the container and drop you at a Bash prompt:

```shell
docker run -it --rm --name my_config-manager --network host config-manager /bin/bash
```

To share pertinent files between host and container:

```shell
docker run -it --rm --name my_config-manager --network host -v $(pwd)/code:/code config-manager /bin/bash
```

## Produce to Kafka

It's assumed that Confluent Platform is running using `example/cp-all-in-one`.

Also, that there's a topic named `config_user_rules`.

Run the container - it'll emit one record as programmed:

```shell
docker run -it --rm --name my_config-manager --network host config-manager
```

Run *in* the container. Choose your favorite way from the `Build & Develop` section and once at the command prompt run:

```shell
mvn -q exec:java -Dexec.mainClass=com.jundy.avro.App
```
