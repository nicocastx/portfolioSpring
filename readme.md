## Tabla de Contenidos
1. [Características](#características)
2. [Instalación](#instalación)
3. [Uso](#uso)
4. [Tecnologías Utilizadas](#tecnologías-utilizadas)
5. [Contacto](#contacto)

## Características
- Portafolio personal para mostrar proyectos y habilidades.
- API REST para realizar operaciones CRUD sobre proyectos, habilidades y usuarios.
- Diseño simple e intuitivo para destacar proyectos y habilidades.

## Instalación

Para ejecutar la aplicación localmente, sigue estos pasos:

1. **Clona el repositorio:**

    ```bash
    git clone https://github.com/nicocastx/portfolioSpring.git
    cd portfolioSpring
    ```

2. **Asegúrate de tener [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) y [Maven](https://maven.apache.org/download.cgi) instalados en tu máquina.**


3. **Construye y ejecuta la aplicación:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. La aplicación debería estar corriendo en `http://localhost:8080`.

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder a los siguientes endpoints:

- **/projects**: Proyectos en los que trabaje.
- **/contact**: Para enviarme un correo.

Por ejemplo, para obtener una lista de proyectos:

```bash
GET http://localhost:8080/api/projects
```
Puedes probar la API usando herramientas como Postman o cURL.


## Tecnologías Utilizadas
- Java 21
- Spring Boot
- Json para base de datos basica
- Maven
- Thymeleaf

## Contacto
Para preguntas o posibles colaboraciones, puedes contactarme:

- Autor: Kevin Castillo
- Email: your.email@example.com
- GitHub: nicocastx