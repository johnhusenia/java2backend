FROM jelastic/maven:3.9.5-openjdk-21 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /app/target/john-0.0.1-SNAPSHOT.jar john.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "john.jar"]
