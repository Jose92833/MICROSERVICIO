# syntax=docker/dockerfile:1

FROM eclipse-temurin:21-jdk-jammy as build

WORKDIR /build

# Copiar wrapper y permisos
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/
COPY pom.xml .

# Descargar dependencias
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw dependency:go-offline -DskipTests

# Copiar código fuente
COPY ./src src/

# Compilar proyecto (genera WAR)
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw package -DskipTests

# ================================================
# SEGUNDA ETAPA — Runtime
# ================================================
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copiar el WAR generado
COPY --from=build /build/target/*.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]
