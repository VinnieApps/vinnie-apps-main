#!/bin/bash

echo $1

parent=$(dirname $1)
filename=$(basename -- "$1")
extension="${filename##*.}"
filename="${filename%.*}"
new_filename=$parent/$filename.png

echo "Converting diagram $1 to $new_filename"
npx -p mermaid.cli mmdc -i "$1" -o "$new_filename"
