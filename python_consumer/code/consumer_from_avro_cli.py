#!/usr/bin/env python
#
# Copyright 2018 Confluent Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

import argparse
from uuid import uuid4

from six.moves import input

from confluent_kafka import avro

conf = {'bootstrap.servers': 'localhost:9092',
        'schema.registry.url': 'http://localhost:8081',
        'group.id': 'python_consumer',
        'auto.offset.reset': 'earliest'}

from confluent_kafka.avro import AvroConsumer
from confluent_kafka.avro.serializer import SerializerError

print("Consuming user records from topic {} with group {}. ^c to exit.".format(topic, conf["group.id"]))

c = AvroConsumer(conf, reader_value_schema=record_schema)
c.subscribe([topic])

while True:
    try:
        msg = c.poll(1)

        # There were no messages on the queue, continue polling
        if msg is None:
            continue

        if msg.error():
            print("Consumer error: {}".format(msg.error()))
            continue

        record = User(msg.value())
        print("name: {}\n\tfavorite_number: {}\n\tfavorite_color: {}\n".format(
            record.name, record.favorite_number, record.favorite_color))
    except SerializerError as e:
        # Report malformed record, discard results, continue polling
        print("Message deserialization failed {}".format(e))
        continue
    except KeyboardInterrupt:
        break

print("Shutting down consumer..")
c.close()


