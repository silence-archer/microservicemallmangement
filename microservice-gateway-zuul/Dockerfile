FROM java:8-jre
MAINTAINER silence <1048037315@qq.com>
ADD ./target/microservice-gateway-zuul-1.0-SNAPSHOT.jar\
    /app/microservice-gateway-zuul.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-gateway-zuul.jar"]
EXPOSE 8050