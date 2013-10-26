#!/bin/sh


PREFIX="https://s3.amazonaws.com/node-webkit/v0.8.0-rc1/"
FILENAME="node-webkit-v0.8.0-rc1-linux-x64"
FILE="${FILENAME}.tar.gz"


if [ -e "lib/$FILE" ]
then 
  echo "Node-webkit Already Exists, run as lib/nw"
else
  mkdir lib/ -p
  wget ${PREFIX}${FILE} -P lib/
  cd lib/
  tar zxvf $FILE

  ln -s $FILENAME/nw ./nw
  echo "Node-webkit downloaded, run as lib/nw"
  cd ..
fi

bower install
