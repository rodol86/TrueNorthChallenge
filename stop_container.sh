#!/bin/sh
docker rm $(docker stop $(docker ps -a -q --filter ancestor=truenorth/java-challenge --format="{{.ID}}"))