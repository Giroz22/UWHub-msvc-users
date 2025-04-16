FROM openjdk:17-alpine AS builder

WORKDIR /app

COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
# RUN ./mvnw dependecy:go-offline

COPY ./src ./src
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-alpine

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/target/msvc-users-0.0.1-SNAPSHOT.jar .
EXPOSE 8001
CMD [ "java", "-jar", "msvc-users-0.0.1-SNAPSHOT.jar"]