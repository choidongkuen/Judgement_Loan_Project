docker container run --name mariadbtest
-e MYSQL_ROOT_PASSWORD=1234 -p 3306:3306 -d docker.io/library/mariadb:10.5