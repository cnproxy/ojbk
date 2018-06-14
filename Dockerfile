FROM anapsix/alpine-java:8_jdk
ADD target/*.jar /app.jar
RUN mkdir -p /etc/config/
VOLUME ["/etc/config/"]
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]