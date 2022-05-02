FROM openjdk:8
COPY "./target/appmetrobusdata.jar" "datamb.jar"
EXPOSE 8081
ENTRYPOINT [ "java","-jar", "datamb.jar" ]