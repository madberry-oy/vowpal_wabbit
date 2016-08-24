#!/bin/sh

[[ -z $1 ]] && { echo "Usage: build.sh version"; exit -1; }

make all java

cd java

BUILD=$1
VW_VERSION=`grep -m 1 -oP "version>\K[^-]*" pom.xml`

VERSION="$VW_VERSION.$BUILD"
echo build version: $VERSION

sed "s/<version>$VW_VERSION.*<\/version>/<version>$VERSION<\/version>/g" pom.xml > pom.local

mvn -f pom.local package

rm pom.local
