#!/bin/bash
set -e

# Runs an application from a specific project

if [[ ! $# -eq 1 ]]; then
    echo "Usage:"
    echo
    echo " run.sh ${path}"
    echo
    echo " path   Path to the application to run."
    echo
    exit -1
fi

./gradlew dZ > /dev/null
pushd $1/build/distributions > /dev/null

name=$(basename $1)
rm -Rf $name/
unzip $name.zip > /dev/null
$name/bin/$name

popd > /dev/null
