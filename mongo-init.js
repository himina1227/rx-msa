db = db.getSiblingDB('rxmsa');

db.createCollection('comments');

db.comments.insertMany([
    {
        org: 'helpdev',
        filter: 'EVENT_A',
        addrs: 'http://rest_client_1:8080/wh'
    },
    {
        org: 'helpdev',
        filter: 'EVENT_B',
        addrs: 'http://rest_client_2:8081/wh'
    },
    {
        org: 'github',
        filter: 'EVENT_C',
        addrs: 'http://rest_client_3:8082/wh'
    }
]);

db.createUser({
    user: "rxmsaUser",
    pwd: "rxmsa2022!!",  // Or  "<cleartext password>"
    roles: [
        { role: "clusterAdmin", db: "admin" },
        { role: "readAnyDatabase", db: "admin" },
          "readWrite"
    ],
    mechanisms: [ "SCRAM-SHA-1" ]
})

// db.createUser({
//     user: "rxmsaUser",
//     pwd: "rxmsa2022!!",
//     roles: [ "readWrite", "rxmsa" ]
// })
// adminDB = db.getSiblingDB('admin');
// adminDB.createUser({
//     user: "rxmsaUser",
//     pwd: "rxmsa2022!!",
//     roles: [
//         { role: 'readWrite', db:"rxmsa" }
//     ]
// })