# Perl Consumer
This is container use to demonstrate a Perl consumer using Avro.

## Run
```
docker build -t avro_perl_consumer_example .
docker run -it --network host --rm --name my_avro_perl_consumer_exmample avro_perl_consumer_example /bin/bash
```