#!/bin/bash

echo ":::::::::: Executing maven build ::::::::: ${MVN_REPO_USER}"

# Copy over our settings.xml so the build can resolve dependencies
cp mvn.settings.xml ${HOME}/.m2/settings.xml && ls -la ${HOME}/.m2/settings.xml && curl ifconfig.co


mvn clean install