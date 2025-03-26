#OpenJDK for image creation
From openjdk:21-jdk-slim

#Set Working directory
WORKDIR /app

#Copy the packaged code
COPY target/ExCService-0.0.1-SNAPSHOT.jar app.jar

#Expose the application port
EXPOSE 8090

#To run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]


