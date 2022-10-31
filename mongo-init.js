db.createUser({
    user: 'test',
    pwd: 'test',
    roles: [
        {
            role: 'dbOwner',
            db: 'testtest',
        },
    ],
});