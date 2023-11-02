FROM ubuntu

# set a directory for the app
WORKDIR /usr/src/app

COPY target/cs480-1.0.jar .

RUN apt-get update
RUN apt-get -y install default-jre 

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "cs480-1.0.jar"]