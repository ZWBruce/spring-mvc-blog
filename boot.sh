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

if [ "$1" = "build" ]; then
  mvn clean package
fi

if [ "$1" = "deploy" ]; then
  mvn clean package
  # /usr/local/opt/tomcat/bin/catalina stop
  # cp -f $(find ./**/*.war) /usr/local/Cellar/jetty/9.4.53.v20231009/libexec/webapps
  cp -f $(find ./**/*.war) /usr/local/Cellar/tomcat/10.1.14/libexec/webapps

  # /usr/local/opt/tomcat/bin/catalina start
fi