docker network create redis-net

docker run --name loan-redis \
      -p 6379:6379 \
      --network redis-net\
      -d redis:latest