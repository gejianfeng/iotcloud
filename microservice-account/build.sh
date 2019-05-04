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
cd library-dal
mvn clean
mvn clean install

cd ..
cd library-model
mvn clean
mvn clean install

cd ..
cd library-account-model
mvn clean
mvn clean install

cd ..
cd microservice-account
mvn clean
mvn package
read