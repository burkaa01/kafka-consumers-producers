# kafka-consumers-producers

Fun with Kafka Consumers and Producers!


Build the Spring Boot app:

```bash
cd consumer-producer-app; ./gradlew clean build; cd ..;
```

Build a Docker image:

```bash
docker build -t burkaa01/kafka-consumers-producers ./consumer-producer-app
```

Verify you built the Docker image:

```bash
docker images
```

Start all of the Docker Compose services:

```bash
docker-compose up -d
```
