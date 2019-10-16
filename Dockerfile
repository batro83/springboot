FROM java:8-jdk-alpine
 
RUN mkdir -p /usr/src/app/
WORKDIR /usr/src/app/
COPY build/libs/springboot-0.0.1-SNAPSHOT.jar /usr/src/app
 
EXPOSE 8080
HEALTHCHECK --start-period=120s CMD curl -f http://localhost:8080/ || exit 1

ENTRYPOINT ["sh", "-c"]
CMD [ "java $JAVA_OPTS -jar springboot-0.0.1-SNAPSHOT.jar" ]

#CMD [ "java -XX:+UseG1GC -jar case.jar" ]
