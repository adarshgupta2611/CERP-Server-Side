FROM openjdk:17
WORKDIR /usr/src/app
COPY ./target/cerp-server-docker.jar /usr/src/app/
CMD ["java", "-jar", "cerp-server-docker.jar"]