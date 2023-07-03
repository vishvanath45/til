## Creating new database, user in postgres

# Need to know

`\du` get to know all users and their permission

change roles by connecting to db with new user `\c <db name> <user>` 

connect to postgres using `psql -U postgres`

```
postgres=# create database db_name;
postgres=# create user new_user with password 'passphrase';
postgres=# grant all privileges on database db_name to new_user;
```

