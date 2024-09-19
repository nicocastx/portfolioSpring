## Tabla de Contenidos
1. [Características](#características)
2. [Instalación](#instalación)
3. [Uso](#uso)
4. [Despliegue](#despliegue)
5. [Tecnologías Utilizadas](#tecnologías-utilizadas)
6. [Contribuir](#contribuir)
7. [Licencia](#licencia)
8. [Contacto](#contacto)

## Características
- Portafolio personal para mostrar proyectos y habilidades.
- API REST para realizar operaciones CRUD sobre proyectos, habilidades y usuarios.
- Autenticación y autorización de usuarios.
- Diseño simple e intuitivo para destacar proyectos y habilidades.
- Persistencia de datos mediante una base de datos relacional.

## Instalación

Para ejecutar la aplicación localmente, sigue estos pasos:

1. **Clona el repositorio:**

    ```bash
    git clone https://github.com/nicocastx/portfolioSpring.git
    cd portfolioSpring
    ```

2. **Asegúrate de tener [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) y [Maven](https://maven.apache.org/download.cgi) instalados en tu máquina.**

3. **Configura las propiedades de la aplicación** editando el archivo `src/main/resources/application.properties` para que coincida con tu configuración de base de datos. Ejemplo:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```

4. **Construye y ejecuta la aplicación:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

5. La aplicación debería estar corriendo en `http://localhost:8080`.

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder a los siguientes endpoints:

- **/api/projects**: Operaciones CRUD para proyectos.
- **/api/skills**: Operaciones CRUD para habilidades.
- **/api/users**: Gestión de usuarios.

Por ejemplo, para obtener una lista de proyectos:

```bash
GET http://localhost:8080/api/projects
```
Puedes probar la API usando herramientas como Postman o cURL.

## Despliegue
Esta aplicación puede ser desplegada en un servicio en la nube como Render o Heroku. Para desplegarla:

Crea un nuevo servicio en la plataforma de tu preferencia.
Configura las variables de entorno como spring.datasource.url, spring.datasource.username y spring.datasource.password para que coincidan con tu base de datos en producción.
Construye y despliega la aplicación siguiendo las instrucciones de la plataforma.
Por ejemplo, para desplegar en Render, deberías:

Enlazar tu repositorio de GitHub.

Establecer el comando de construcción:
```bash
mvn clean install
```
Establecer el comando de inicio:
```bash
mvn clean install
```

## Tecnologías Utilizadas
Java 21
Spring Boot
MySQL (para producción)
H2 Database (para desarrollo local)
Maven
Spring Security (para autenticación y autorización)
APIs RESTful
## Contribuir
Las contribuciones son bienvenidas. Sigue estos pasos para contribuir:

- Haz un fork del repositorio.
- Crea una nueva rama para tu funcionalidad: git checkout -b nombre-de-la-funcionalidad.
- Realiza tus cambios y haz un commit: git commit -m 'Añadir nueva funcionalidad'.
- Sube tu rama: git push origin nombre-de-la-funcionalidad.
- Abre un pull request con una descripción detallada de tus cambios.
## Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

## Contacto
Para preguntas o posibles colaboraciones, puedes contactarme:

- Autor: Kevin Castillo
- Email: your.email@example.com
- GitHub: nicocastx