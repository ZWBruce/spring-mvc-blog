#!/bin/sh

set -e

echo "$0, $1"


if [ "$1" = "i" ]; then
    mvn clean install
fi

if [ "$1" = "dev" ]; then
  mvn compile && mvn spring-boot:run
  # mvn compile && mvn tomcat7:run
fi