#!/bin/bash

cd ..
cd library-common
mvn clean
mvn clean install

cd ..
cd library-core
mvn clean
mvn clean install

cd ..
cd microservice-test
mvn clean
mvn package
read
