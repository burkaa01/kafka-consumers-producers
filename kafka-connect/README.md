# kafka-connect

Configurations for Kafka Connect.


Kafka Connect is an open source framework for connecting Kafka with external systems such as databases, key-value stores, search indexes, and file systems. Using Kafka Connect you can use existing connector implementations for common data sources and sinks to move data into and out of Kafka.


A source connector ingests entire databases and streams table updates to Kafka topics. It can also collect metrics from all of your application servers into Kafka topics, making the data available for stream processing with low latency.


The Confluent Platform comes with the file source plugin pre-installed. To verify this, you can `curl localhost:8083/connector-plugins` to see the pre-installed plugins.


The configuration for the file source connector is already setup in `./file-source/file-source.json`. The following curl command will configure the connector pointed at the `example.csv` file (which is mounted to the docker container at `/usr/share/data/file-source`).


```bash
cd file-source

curl -X POST -H "Content-Type: application/json" --data @file-source.json http://localhost:8083/connectors

kafka-console-consumer --bootstrap-server localhost:9092 --topic first-topic --from-beginning

curl http://localhost:8083/connectors
```
