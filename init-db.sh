#!/bin/bash
mongo -- "$MONGO_INITDB_DATABASE" <<EOF
db.createUser({
    user: "$MONGO_INITDB_ROOT_USERNAME",
    pwd: "$MONGO_INITDB_ROOT_PASSWORD",
    roles: [
        { role: 'readWrite', db:"$MONGO_INITDB_DATABASE" }
    ]
})
EOF
##db.createUser(
##  {
##      user: "admin",
##      pwd: "rxmsa2022!!",
##      roles: [
##          {
##              role: "readWrite",
##              db: "msa"
##          }
##      ]
##  }
##);
#
##!/bin/bash
#set -e
#
#mongo <<EOF
#use msa
#db.createUser({
#  user:  rxmsa,
#  pwd: rxmsa2022!!,
#  roles: [{
#    role: 'readWrite',
#    db: msa
#  }]
#})
#EOF