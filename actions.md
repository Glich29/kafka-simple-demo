Run of container
```shell
docker compose start
```

Get list of topics
```shell
docker exec -ti kafka_simple /usr/bin/kafka-topics --list --bootstrap-server localhost:9091
```

Send a message
Every line - one message. To break - Ctrl + Z
```shell
docker exec -ti kafka_simple /usr/bin/kafka-console-producer.sh --topic topic1 --bootstrap-server localhost:9092
```
