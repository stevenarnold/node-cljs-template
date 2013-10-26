#!/bin/sh

./clean.sh

mkdir -p target
cd src
zip ../target/app.nw index.html package.json
