# Configuration Manager 


## Build & Develop
```
docker build --rm=false -t config_manager .
docker run -it --rm --name my_config-manager --network host config-manager /bin/bash
```

To get share pertinent files between host and container:

```
docker run -it --rm --name my_config-manager --netork host -v $(pwd)/code:/code config-manager /bin/bash
```

## Produce to Kafka
It's assumed that Confluent Platform is running using `example/cp-all-in-one`.

Also, that there's a topic named `config_user_rules`.

Run the contain - it'll emit one record as programmed:

```
docker run -it --rm --name my_config-manager --network host config-manager
```

Run the container (choose your favorite way from the `Build & Develop` section) and run:

```
mvn -q exec:java -Dexec.mainClass=com.jundy.avro.App
```