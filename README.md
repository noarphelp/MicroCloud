🏗️ Microservicio Cloud - Gestión de Cursos
Este proyecto es un sistema de microservicios en la nube que gestiona información de cursos y usuarios, implementando arquitectura basada en servicios REST, registro en Eureka y configuración centralizada.

📌 Descripción del Proyecto
El sistema está compuesto por varios microservicios que interactúan entre sí:

1️⃣ Microservicio: Cursos
📌 Función: Gestiona los cursos almacenados en una base de datos.
🔹 Guarda información de los cursos y usuarios.
🔹 Los usuarios tienen roles que determinan sus permisos.
🔹 Expone una API REST para obtener, crear y modificar cursos.

2️⃣ Microservicio: Info-Cursos
📌 Función: Actúa como cliente del servicio de Cursos.
🔹 Se conecta al microservicio Cursos para solicitar información.
🔹 Realiza peticiones REST sin conocer la IP ni el puerto del servicio.
🔹 Usa Eureka Server para descubrir dinámicamente el servicio.

3️⃣ Servidor Eureka
📌 Función: Registro y descubrimiento de servicios.
🔹 Permite que los microservicios se encuentren entre sí.
🔹 Cursos y Info-Cursos se registran automáticamente.
🔹 Facilita la escalabilidad y balanceo de carga.

4️⃣ Servidor de Configuración (Config Server) [Próximo]
📌 Función: Gestión centralizada de configuración.
🔹 Almacenará la configuración de los microservicios.
🔹 Evita duplicar configuraciones en cada servicio.
🔹 Permitirá actualizar ajustes sin reiniciar servicios.

⚙️ Tecnologías Utilizadas
🔹 Spring Boot - Framework principal
🔹 Spring Cloud Netflix Eureka - Descubrimiento de servicios
🔹 Spring Cloud Config - Configuración centralizada (pendiente)
🔹 Spring Security - Autenticación y autorización
🔹 MySQL - Base de datos para almacenar cursos y usuarios
🔹 Docker (Opcional) - Para despliegue y contenedorización

⚠️ Importante sobre las Credenciales en el Código
🚨 Este proyecto es solo de prueba y no se usará en producción.
✅ Las credenciales y configuraciones de la base de datos son ficticias y se encuentran en los archivos de configuración únicamente con fines educativos.
❌ No se recomienda subir credenciales reales a un repositorio público.

🚀 Cómo Ejecutarlo
Clonar el repositorio

bash

git clone https://github.com/tuusuario/microsistema-cursos.git
cd microsistema-cursos


Levantar Eureka Server
bash

cd eureka-server
mvn spring-boot:run


Iniciar el servicio de Cursos
bash

cd servicio-cursos
mvn spring-boot:run


Iniciar el servicio Info-Cursos
bash

cd info-cursos
mvn spring-boot:run

