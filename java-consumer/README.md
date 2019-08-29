# Java Consumer 


## Build & Develop
### Build
```
docker build --rm=false -t java_consumer .
```

### Develop
This will start the container and drop you at a Bash prompt.
```
docker run -it --rm --name my_java_consumer --network host java_consumer /bin/bash
```

To get share pertinent files between host and container:

```
docker run -it --rm --name my_java_consumer --netork host -v $(pwd)/code:/code java_consumer /bin/bash
```

## Consume from Kafka Topic
It's assumed that Confluent Platform is running using `example/cp-all-in-one`.

Also, that there's a topic named `config_user_rules`.

Run the container - it'll consume every record from the topic each time it is run:

```
docker run -it --rm --name my_java_consumer --network host java_consumer
```

Run *in* the container. Choose your favorite way from the `Build & Develop` section and once at the command prompt run

```
mvn -q exec:java -Dexec.mainClass=com.jundy.avro.App
```