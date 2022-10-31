db.createUser(
    {
        user: "storeAdmin",
        pwd: "storeAdmin2022",
        roles: [
            {
                role: "readWrite",
                db: "bankAccount"
            }
        ]
    }
);
db.createCollection("test");
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