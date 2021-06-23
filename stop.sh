#!/bin/sh
jarPID=`ps -f | grep jar | grep rest-service-0.0.1-SNAPSHOT.jar | awk '{print $2}'`

kill -9 $jarPID