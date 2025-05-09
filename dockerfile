FROM eclipse-temurin:17-alpine AS builder

WORKDIR /app

COPY ./pom.xml /app/

COPY ./mvnw /app/

COPY .mvn /app/.mvn

RUN ./mvnw dependency:go-offline

COPY ./src /app/src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-alpine

WORKDIR /app/

COPY --from=builder /app/target/uwhub-msvc-users-1.0.0-ALPHA.jar /app/

EXPOSE 8000

CMD [ "java", "-jar", "uwhub-msvc-users-1.0.0-ALPHA.jar" ]