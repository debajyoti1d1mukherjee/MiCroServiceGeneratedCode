FROM java:8-alpine
VOLUME /balance
ADD createcase 0.0.1-SNAPSHOT app.jar
RUN sh -c 'touch app.jar'
EXPOSE 8090
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]
