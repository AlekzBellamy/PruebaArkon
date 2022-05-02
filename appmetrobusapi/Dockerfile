FROM openjdk:8
COPY "./target/appmetrobusapi.jar" "apimb.jar"
EXPOSE 8083
ENTRYPOINT [ "java","-jar", "apimb.jar" ]