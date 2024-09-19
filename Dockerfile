FROM amazoncorretto:21-alpine-jdk

COPY portfolioKevinCastillo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

# Copiar el archivo JSON al contenedor
COPY src/main/resources/data/projects.json /app/data/projects.json

# Establecer el directorio de trabajo
WORKDIR /app
