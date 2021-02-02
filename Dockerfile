FROM openjdk:8-jre-slim

MAINTAINER BoyangWang/845657927@qq.com

#VOLUME ["/tmp"]

COPY ./target/myflix-0.0.1-SNAPSHOT.jar myflix.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "myflix.jar"]
