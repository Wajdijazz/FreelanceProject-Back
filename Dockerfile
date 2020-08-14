FROM java:8
EXPOSE 8080
ADD target/FreeLanceBack-0.0.1-SNAPSHOT.jar FreeLanceBack-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","FreeLanceBack-0.0.1-SNAPSHOT.jar"]
