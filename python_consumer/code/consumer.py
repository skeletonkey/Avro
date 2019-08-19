from confluent_kafka import KafkaError
from confluent_kafka.avro import AvroConsumer
from confluent_kafka.avro.serializer import SerializerError


c = AvroConsumer({
    'bootstrap.servers': 'localhost:9092',
    'group.id': 'python_consumer',
    'schema.registry.url': 'http://127.0.0.1:8081',
    'enable.auto.commit': False,
    'auto.offset.reset': 'earliest'})

c.subscribe(['config_user_rules'])

while True:
    try:
        msg = c.poll(100)

    except SerializerError as e:
        print("Message deserialization failed for: {}".format(e))
        # print("Message deserialization failed for {}: {}".format(msg, e))
        break

    if msg is None:
        print("No msg received")
        continue

    if msg.error():
        print("AvroConsumer error: {}".format(msg.error()))
        continue

    print(msg.value())

c.close()
