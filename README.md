ForoNotasIA

Descripción del proyecto

ForoNotasIA es una aplicación web diseñada para la gestión de un foro estudiantil integrado con un analizador de notas impulsado por inteligencia artificial. En esta primera fase, el enfoque está en la construcción del back-end utilizando Spring Boot, con conexión a una base de datos SQL Server mediante JPA/Hibernate, y el desarrollo de la estructura inicial de clases para gestionar las diferentes tablas de la base de datos.

La aplicación proporcionará un foro interactivo donde los estudiantes podrán discutir temas académicos, y un sistema que analizará sus calificaciones, ofreciendo sugerencias basadas en IA para mejorar el rendimiento académico.

Tecnologías utilizadas

Java 21: Lenguaje de programación utilizado para el desarrollo del back-end.
Spring Boot 3.3.4: Framework para la construcción del back-end, que proporciona facilidad para crear aplicaciones Java empresariales.
Spring Data JPA: Para el manejo de la persistencia de datos y la conexión con bases de datos relacionales.
SQL Server: Sistema de gestión de bases de datos relacional utilizado en la aplicación.
Thymeleaf: Motor de plantillas para la generación dinámica de contenido HTML (se utilizará en las siguientes fases).
Maven: Herramienta de gestión de dependencias y automatización de compilaciones.
Lombok: Biblioteca para reducir el código boilerplate en las entidades.
Postman: Herramienta utilizada para probar los endpoints del API en esta fase.
Características de la primera fase
Conexión con base de datos: Integración de Spring Boot con SQL Server mediante JPA y Hibernate.
Estructura del proyecto: Creación de los paquetes y clases base para cada entidad de la base de datos, incluyendo Model, Repository, Service, y Controller.
Operaciones CRUD: Implementación de las operaciones CRUD básicas para las entidades principales (como usuarios, notas, etc.).
Pruebas con Postman: Endpoints creados para interactuar con las entidades desde el navegador o mediante herramientas como Postman.
Preparación para la integración del frontend: Configuración inicial para el uso futuro de Thymeleaf para las vistas.
Requisitos previos
Antes de clonar y ejecutar este proyecto, asegúrate de tener lo siguiente instalado en tu sistema:

Java 21 o superior
Maven 3.8.x o superior
SQL Server (recomendado: SQL Server Management Studio)
Postman (opcional, para probar los endpoints)
Configuración del entorno de desarrollo
Sigue estos pasos para clonar, configurar y ejecutar el proyecto:

1. Clonar el repositorio
bash
Copiar código
git clone https://github.com/tu-usuario/ForoNotasIA.git
cd ForoNotasIA
2. Configurar la base de datos SQL Server
Crea una base de datos en SQL Server para el proyecto.
Configura la conexión a la base de datos en el archivo application.properties:
properties
Copiar código
# src/main/resources/application.properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=ForoNotasIA
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
3. Ejecutar el proyecto
Compila y ejecuta el proyecto con Maven:

bash
Copiar código
mvn clean install
mvn spring-boot:run
El servidor Spring Boot estará corriendo en http://localhost:8080.

4. Probar los endpoints
Puedes probar los endpoints usando Postman o cURL. Por ejemplo, un endpoint básico para listar los usuarios:

GET: http://localhost:8080/usuarios
Consulta la sección "Documentación de API" para más detalles sobre los endpoints disponibles.

Estructura del proyecto
El proyecto está organizado en paquetes de acuerdo a la arquitectura MVC (Modelo-Vista-Controlador) de Spring Boot. La siguiente es una estructura simplificada de las carpetas más importantes:

bash
Copiar código
src/
│
├── main/
│   ├── java/com/IngSoftware/ForoNotasIA/
│   │   ├── controller/       # Controladores que manejan las solicitudes HTTP
│   │   ├── model/            # Entidades (tablas de la BD)
│   │   ├── repository/       # Interfaces de persistencia JPA
│   │   ├── service/          # Servicios que contienen la lógica de negocio
│   └── resources/
│       ├── templates/        # Plantillas Thymeleaf (se agregarán en la siguiente fase)
│       └── application.properties   # Configuración de la BD y propiedades del proyecto
└── test/                     # Pruebas unitarias
