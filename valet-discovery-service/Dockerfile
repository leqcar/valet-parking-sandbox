FROM java:openjdk-8u92-jdk-alpine
VOLUME /tmp
ADD valet-discovery-service-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]