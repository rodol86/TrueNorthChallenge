#!/bin/sh
jarPID=`ps -f | grep jar | grep truenorth | awk '{print $2}'`

kill -9 $jarPID