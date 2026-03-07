<div align="center">

# 🏥 Voll.med API

### API REST para Gestión de Consultas Médicas

[![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen?style=for-the-badge&logo=spring)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-4.0.0-C71A36?style=for-the-badge&logo=apache-maven)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![JWT](https://img.shields.io/badge/JWT-Auth-000000?style=for-the-badge&logo=json-web-tokens)](https://jwt.io/)
[![Swagger](https://img.shields.io/badge/Swagger-3.0.2-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://swagger.io/)

</div>

---

## 📋 Descripción

**Voll.med** es una API REST robusta y segura diseñada para gestionar consultas médicas, médicos y pacientes. El sistema permite el registro, actualización y consulta de información médica con autenticación JWT y validaciones de negocio.

### ✨ Características Principales

- 🔐 **Autenticación JWT** - Sistema de seguridad basado en tokens
- 👨‍⚕️ **Gestión de Médicos** - CRUD completo con especialidades
- 👥 **Gestión de Pacientes** - Registro y control de pacientes
- 📅 **Sistema de Consultas** - Reserva y cancelación de citas médicas
- ✅ **Validaciones de Negocio** - Reglas de negocio para reservas
- 📖 **Documentación Swagger** - API documentada con OpenAPI 3.0
- 🔄 **HATEOAS** - Hipermedia para navegación de recursos
- 🗄️ **Migraciones Flyway** - Control de versiones de base de datos
- 📊 **Paginación** - Resultados paginados para mejor rendimiento

---

## 🛠️ Tecnologías

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 17 | Lenguaje de programación |
| **Spring Boot** | 4.0.3 | Framework principal |
| **Spring Security** | - | Autenticación y autorización |
| **Spring Data JPA** | - | Persistencia de datos |
| **Hibernate** | - | ORM |
| **MySQL** | 8.0+ | Base de datos |
| **Flyway** | - | Migraciones de BD |
| **Lombok** | - | Reducción de código boilerplate |
| **Auth0 JWT** | 4.5.1 | Generación y validación de tokens |
| **SpringDoc OpenAPI** | 3.0.2 | Documentación de API |
| **Maven** | 4.0.0 | Gestión de dependencias |

---

## 🚀 Inicio Rápido

### Prerrequisitos

- ☕ JDK 17 o superior
- 🗄️ MySQL 8.0 o superior
- 🔧 Maven 3.6+

### Instalación

1. **Clonar el repositorio**
```bash
git clone <repository-url>
cd api
```

2. **Configurar Base de Datos**
```sql
CREATE DATABASE vollmed_api;
```

3. **Configurar Variables de Entorno**
```bash
# Windows PowerShell
$env:DB_MYSQL_PASSWORD="tu_password"
$env:JWT_SECRET="tu_secreto_jwt"

# Linux/Mac
export DB_MYSQL_PASSWORD="tu_password"
export JWT_SECRET="tu_secreto_jwt"
```

4. **Ejecutar Migraciones**
```bash
mvn flyway:migrate
```

5. **Compilar el Proyecto**
```bash
mvn clean install
```

6. **Ejecutar la Aplicación**
```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8081`

---

## 📚 Documentación de la API

### Swagger UI

Una vez que la aplicación esté en ejecución, accede a la documentación interactiva:

🔗 **http://localhost:8081/swagger-ui.html**

### Endpoints Principales

#### 🔐 Autenticación

```http
POST /login
Content-Type: application/json

{
  "login": "usuario",
  "clave": "password"
}
```

#### 👨‍⚕️ Médicos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/medicos` | Registrar nuevo médico |
| `GET` | `/medicos` | Listar médicos activos (paginado) |
| `GET` | `/medicos/{id}` | Obtener médico por ID |
| `PUT` | `/medicos` | Actualizar datos del médico |
| `DELETE` | `/medicos/{id}` | Desactivar médico (borrado lógico) |

#### 👥 Pacientes

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/pacientes` | Registrar nuevo paciente |
| `GET` | `/pacientes` | Listar pacientes activos (paginado) |
| `GET` | `/pacientes/{id}` | Obtener paciente por ID |
| `PUT` | `/pacientes` | Actualizar datos del paciente |
| `DELETE` | `/pacientes/{id}` | Desactivar paciente |

#### 📅 Consultas

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/consultas` | Reservar una consulta |
| `DELETE` | `/consultas` | Cancelar una consulta |

---

## 🗂️ Estructura del Proyecto

```
api/
├── src/
│   ├── main/
│   │   ├── java/med/voll/api/
│   │   │   ├── config/           # Configuraciones
│   │   │   ├── controller/       # Controladores REST
│   │   │   ├── domain/           # Entidades y lógica de negocio
│   │   │   │   ├── consulta/     # Dominio de consultas
│   │   │   │   ├── medico/       # Dominio de médicos
│   │   │   │   ├── paciente/     # Dominio de pacientes
│   │   │   │   └── usuario/      # Dominio de usuarios
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   └── infra/            # Infraestructura y seguridad
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/migration/     # Scripts Flyway
│   └── test/                     # Tests unitarios e integración
├── pom.xml
└── README.md
```

---

## 🔒 Seguridad

- **Autenticación**: JWT (JSON Web Tokens)
- **Autorización**: Spring Security
- **Encriptación**: BCrypt para contraseñas
- **CORS**: Configurado para peticiones cross-origin
- **Validación**: Bean Validation en todos los endpoints

---

## 🗃️ Base de Datos

### Migraciones Flyway

Las migraciones se ejecutan automáticamente al iniciar la aplicación:

| Versión | Descripción |
|---------|-------------|
| V1 | Creación tabla médicos |
| V2 | Agregar columna teléfono a médicos |
| V3 | Agregar columna activo a médicos |
| V4 | Creación tabla pacientes |
| V5 | Agregar columna activo a pacientes |
| V6 | Creación tabla usuarios |
| V7 | Creación tabla consultas |
| V8 | Agregar motivo de cancelamiento |

---

## ⚙️ Configuración

### Perfiles de Aplicación

El proyecto soporta múltiples perfiles:

- **default**: Desarrollo local
- **test**: Pruebas
- **prod**: Producción

Configurar con:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

### Propiedades Principales

```properties
# Servidor
server.port=8081

# Base de Datos
spring.datasource.url=jdbc:mysql://localhost/vollmed_api
spring.datasource.username=root
spring.datasource.password=${DB_MYSQL_PASSWORD}

# JWT
api.security.token.secret=${JWT_SECRET}

# JPA
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🧪 Testing

Ejecutar todos los tests:
```bash
mvn test
```

Ejecutar con reporte de cobertura:
```bash
mvn test jacoco:report
```

---

## 📦 Build y Deploy

### Crear JAR ejecutable

```bash
mvn clean package
```

### Ejecutar JAR

```bash
java -jar target/api-0.0.1-SNAPSHOT.jar
```

### Docker (Opcional)

```dockerfile
# Ejemplo de Dockerfile
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add: AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

---

## 📝 Licencia

Este proyecto es parte del programa **Oracle Next Education (ONE)** en colaboración con **Alura LATAM**.

---

## 👥 Autor

Desarrollado como parte del curso de Spring Boot de Alura LATAM.

---

## 📞 Contacto

¿Tienes preguntas? Abre un issue en el repositorio.

---

<div align="center">

**⭐ Si este proyecto te fue útil, considera darle una estrella ⭐**

Hecho con ❤️ usando Spring Boot

</div>

