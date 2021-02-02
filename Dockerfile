FROM openjdk:8-jre-slim

MAINTAINER BoyangWang/845657927@qq.com

#VOLUME ["/tmp"]

EXPOSE 8080

ADD /var/jenkins_home/workspace/myflix/target/myflix-0.0.1-SNAPSHOT.jar myflix.jar

ENTRYPOINT ["java", "-jar", "myflix.jar"]
