docker run -d \
--name loan-Mysql \
-e MYSQL_ROOT_PASSWORD="loan" \
-e MYSQL_USER="loan" \
-e MYSQL_PASSWORD="loan" \
-e MYSQL_DATABASE-"loan" \
-p 3305:3305 \
mysql:latest