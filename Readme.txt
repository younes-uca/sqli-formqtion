to run the getway proprely:
1- lunch Docker
2-docker network create -d bridge redisnet
3-docker run -d -p 6379:6379 --name myrediscontainer --network redisnet redis