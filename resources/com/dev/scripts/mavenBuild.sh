#!/bin/bash

echo ":::::::::: Executing maven build ::::::::: ${MVN_REPO_USER}"

# Copy over our settings.xml so the build can resolve dependencies
cp mvn.settings.xml ${HOME}/.m2/settings.xml && ls -la ${HOME}/.m2/settings.xml && curl ifconfig.co

# This entry fixes issues with maven cache clean or new maven version update in travis
mvn help:evaluate -Dexpression=project.version | grep -Ev '(^\[|Download\w+:)'
# Get the project name
export APPLICATION=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec`
# Get the maven version number
export POM_VERSION=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec`
#  App version = POM version - build number. Major.Minor.BugFix-BuildNumber



if [ -z $TAG_NAME ]
then
    export VERSION=${POM_VERSION}-${BUILD_NUMBER}
    echo "VERSION = $VERSION"
else
    export VERSION=$TAG_NAME
    echo "Building release tag $TAG and deploying"
fi

# Label required by application
export APPLICATION_LABEL=$VERSION
echo "Building application $APPLICATION"
echo "Building version $VERSION"


mvn clean install site -B -U
