FROM openjdk:17-alpine
MAINTAINER NICO
COPY target/myinvest-0.0.1-SNAPSHOT.jar myinvest-app.jar
ENTRYPOINT ["java","-jar","/myinvest-app.jar"]
EXPOSE 8080