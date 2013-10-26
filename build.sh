#!/bin/sh

./clean.sh
./deps.sh

mkdir -p target
cd src
zip -r ../target/app.nw *
