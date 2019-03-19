FROM java:8-jre
MAINTAINER silence <1048037315@qq.com>
ADD ./target/microservice-orderservice-1.0-SNAPSHOT.jar\
    /app/microservice-orderservice.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-orderservice.jar"]
EXPOSE 7900