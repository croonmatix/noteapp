# Proyecto NoteApp

La aplicación permite crear, editar, eliminar notas y gestionarlas mediante etiquetas, todo esto protegido por autenticación JWT.

## Tecnologías utilizadas

- **Java 21**: Lenguaje de programación utilizado para el desarrollo del backend.
- **Spring Boot 3.4.2**: Framework utilizado para construir la aplicación de manera rápida y eficiente.
- **JWT (JSON Web Tokens)**: Utilizado para la autenticación de los usuarios.
- **PostgreSQL**: Base de datos utilizada para almacenar la información de usuarios, notas y etiquetas.
- **Eclipse IDE**: Entorno de desarrollo integrado utilizado para escribir y ejecutar el código.

## Funcionalidades

- **Gestión de usuarios**:
  - Registro de nuevos usuarios.
  - Autenticación de usuarios mediante JWT.
  - Obtener información del usuario autenticado.
  
- **Gestión de notas**:
  - Crear, editar y eliminar notas.
  - Listar todas las notas del usuario autenticado.
  - Búsqueda avanzada por título, etiquetas o contenido.

- **Gestión de etiquetas**:
  - Crear nuevas etiquetas.
  - Asignar etiquetas a notas.
  - Eliminar etiquetas.

## Cómo usar

1. **Registro de usuario**:
   - Envía una solicitud POST a `/api/users/register` con los parámetros necesarios (`username`, `password`, `email`).
   
2. **Autenticación de usuario**:
   - Envía una solicitud POST a `/api/auth/login` con `username` y `password` para obtener un JWT.
   - Usa este token en los encabezados de las siguientes solicitudes para autenticarte.

3. **Gestión de notas**:
   - Para crear una nueva nota, envía una solicitud POST a `/api/notes` con los datos de la nota.
   - Para listar las notas, usa `/api/notes` con el parámetro `userId`.
   - Puedes editar y eliminar notas a través de los endpoints correspondientes.
   
4. **Gestión de etiquetas**:
   - Crear y asociar etiquetas a notas usando los endpoints de `/api/tags`.

## Instalación

1. **Clonar el repositorio**:
   - `git clone https://github.com/tuusuario/noteapp.git`

2. **Instalar dependencias**:
   - Asegúrate de tener Java 21 y PostgreSQL instalados.
   - Importa el proyecto en Eclipse y espera que Maven descargue las dependencias necesarias.

3. **Configurar PostgreSQL**:
   - Crea una base de datos llamada `noteapp` en PostgreSQL.
   - Configura las credenciales en el archivo `application.properties`.

4. **Ejecutar la aplicación**:
   - Corre la aplicación desde Eclipse usando el comando de ejecución estándar de Spring Boot.
   - La API estará disponible en `http://localhost:8080`.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar el proyecto, por favor abre un "issue" o crea un "pull request".
