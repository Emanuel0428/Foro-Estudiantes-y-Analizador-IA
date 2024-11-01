# Usa una imagen base de JDK para compilar y ejecutar la aplicación
FROM openjdk:17-jdk-alpine AS builder

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml y el código fuente de la aplicación al contenedor
COPY pom.xml ./
COPY src ./src

# Compila el proyecto
RUN ./mvnw package -DskipTests

# Usa una imagen más ligera para ejecutar la aplicación
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR compilado de la fase anterior al contenedor
COPY --from=builder /app/target/*.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
