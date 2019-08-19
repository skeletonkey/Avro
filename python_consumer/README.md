# Python Consumer 


## Build & Develop
```
docker build --rm=false -t python_consumer .
docker run -it --rm --name my_python_consumer --network host python_consumer /bin/bash
```

To get share pertinent files between host and container:

```
docker run -it --rm --name my_python_consumer --netork host -v $(pwd)/code:/code python_consumer /bin/bash
```

## Consume from Kafka Topic
It's assumed that Confluent Platform is running using `example/cp-all-in-one`.

Also, that there's a topic named `config_user_rules`.

Run the container - it'll consume every record from the topic each time it is run:

```
docker run -it --rm --name my_python_consumer --network host python_consumer
```

Run the container (choose your favorite way from the `Build & Develop` section) and run:

```
mvn -q exec:python -Dexec.mainClass=com.jundy.avro.App
```

## Notes
`avro_python.tgz` was created by taring up the `lang/py3` directory of the [Avro source code](http://avro.apache.org/releases.html) (version 1.9).
