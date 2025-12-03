# syntax=docker/dockerfile:1

FROM eclipse-temurin:21-jdk-jammy as build

WORKDIR /build

COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/
COPY pom.xml .

RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw dependency:go-offline -DskipTests

COPY ./src src/

RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw package -DskipTests


# =============================
#  RUNTIME
# =============================
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

# Render asignará dinámicamente el puerto con $PORT
ENV PORT=8080
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
