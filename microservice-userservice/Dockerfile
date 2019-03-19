FROM java:8-jre
MAINTAINER silence <1048037315@qq.com>
ADD ./target/microservice-userservice-1.0-SNAPSHOT.jar\
    /app/microservice-userservice.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-userservice.jar"]
EXPOSE 8030