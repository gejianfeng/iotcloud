#!/bin/bash

cd ..
cd library-model
mvn clean
mvn clean install

cd ..
cd library-account-model
mvn clean
mvn clean install

read