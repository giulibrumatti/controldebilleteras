# Aplicación de Gestión de Billeteras

Este proyecto es una aplicación web desarrollada en **Java** que permite la gestión de diferentes tipos de billeteras (MercadoPago, banco y efectivo) y sus respectivas transacciones. La aplicación está diseñada para permitir a los usuarios realizar operaciones como depósitos, retiros y consultar el saldo disponible en cada billetera.

## Características Principales

- **Gestión de Usuarios:**
  - Inicialización de usuarios en la base de datos.
  - Funcionalidades CRUD (Crear, Leer, Actualizar, Eliminar) para administrar la información de los usuarios.
  
- **Gestión de Billeteras:**
  - Manejo de diferentes tipos de billeteras: MercadoPago, banco y efectivo.
  
- **Gestión de Transacciones:**
  - Permite listar, agregar, eliminar y actualizar transacciones.
  - Cada transacción incluye detalles como monto, fecha, tipo (depósito o retiro) y se asocia a una billetera específica.
  
- **Visualización del Saldo:**
  - Muestra el saldo disponible en cada billetera, considerando todas las transacciones realizadas.

## Tecnologías Utilizadas

### Backend

- **Java con JSP y Servlets:** Implementación de la capa de presentación y lógica del negocio.
- **JPA (Java Persistence API):** Para la persistencia de datos y el mapeo objeto-relacional.
- **Apache Tomcat:** Servidor de aplicaciones utilizado para desplegar la aplicación.
- **MySQL:** Base de datos relacional utilizada para almacenar la información de usuarios, transacciones y billeteras.

### Frontend

- **HTML, CSS y Bootstrap:** Diseño responsivo y amigable para la interfaz de usuario.

### Testing

- **JUnit 4:** Implementación de pruebas unitarias para asegurar la calidad del código.