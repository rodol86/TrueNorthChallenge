#!/bin/sh
docker build -t truenorth/java-challenge .

docker container run --rm -p 8080:8080 -t truenorth/java-challenge