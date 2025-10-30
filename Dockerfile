# Etapa 1: build com Maven
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagem final com JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/camed.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]