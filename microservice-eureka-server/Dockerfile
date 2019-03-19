FROM java:8-jre
MAINTAINER silence <1048037315@qq.com>
ADD ./target/microservice-eureka-server-1.0-SNAPSHOT.jar\
    /app/microservice-eureka-server.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-eureka-server.jar"]
EXPOSE 8761