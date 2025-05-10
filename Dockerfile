FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Копіюємо файли проекту Maven
COPY pom.xml .
COPY src/ ./src/

# Збираємо додаток з пропуском тестів
RUN mvn clean package -DskipTests

# Другий етап збірки для мінімізації розміру образу
FROM eclipse-temurin:17-jre

WORKDIR /app

# Копіюємо зібраний JAR з першого етапу
COPY --from=build /app/target/*.jar app.jar

# Запускаємо Spring Boot додаток
CMD ["java", "-jar", "app.jar"]