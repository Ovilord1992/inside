#select parent image
FROM maven:3.8.3-jdk-11-slim
#copy the source tree and the pom.xml to our new container
COPY ./ ./
#package our application code
RUN mvn clean package
#set the startup comand to execute the jar
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
