FROM openjdk:8-jre-slim

MAINTAINER BoyangWang/845657927@qq.com

VOLUME ["/tmp"]

EXPOSE 8080

COPY myflix.jar myflix.jar

ENTRYPOINT ["java", "-jar", "myflix.jar"]
