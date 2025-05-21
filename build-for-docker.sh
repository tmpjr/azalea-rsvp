#!/bin/bash
docker run --platform linux/amd64 -v $(pwd):/app -w /app gradle:jdk17 ./gradlew clean bootJar
