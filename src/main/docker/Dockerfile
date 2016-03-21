FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD allegro-api-service.0.6.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]