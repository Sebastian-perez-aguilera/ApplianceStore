El proyecto desarrollado consiste en una Tienda de Electrodomésticos Online con arquitectura de microservicios, diseñada para garantizar una experiencia de compra fluida y eficiente para los usuarios. 
Este proyecto aborda las necesidades de una tienda, según las especificaciones técnicas proporcionadas por un Analista Funcional, y se centra en tres microservicios principales: Productos, Carrito de Compras y Ventas.

Arquitectura del Sistema: Para este proyecto, se diseñó una arquitectura de microservicios modular e independiente, donde cada microservicio se encarga de una funcionalidad específica. 
Estos servicios se comunican entre sí de manera sincrónica a través de REST API, utilizando Spring Cloud Eureka para la descubrir servicios.

Microservicio de Productos:

Gestión de electrodomésticos disponibles en la plataforma.
CRUD para registrar, listar, modificar y eliminar productos.
Detalles administrados: código, nombre, marca y precio individual.
Balanceo de carga implementado con Spring Cloud Load Balancer, ejecutando múltiples instancias para gestionar peticiones concurrentes.
Microservicio de Carrito de Compras:

Manejo del carrito para usuarios.
Operaciones para agregar, eliminar y listar productos.
Campos principales: id del carrito y cálculo del precio total dinámico según los productos añadidos.
Microservicio de Ventas:

Registro de las ventas realizadas.
Cada venta almacena un identificador único, fecha y el carrito asociado.
Capacidad para consultar la lista de productos vendidos y su precio total mediante integración con los servicios de Carrito y Productos.
Requerimientos Técnicos Cubiertos:

Diagrama Representativo de la Arquitectura:
Se elaboró un diagrama vertical que muestra la relación y comunicación entre los microservicios. Se incluye el Eureka Server, que registra y localiza cada servicio, y una API Gateway como único punto de entrada para clientes externos.

Desarrollo de los Servicios:

Cada microservicio fue configurado con sus respectivos CRUDs.
Uso de configuraciones centralizadas para application.properties con un Config Server, optimizando la administración de cambios.
Eureka Server:

Se implementó un servidor Eureka para registrar los microservicios con nombres representativos, garantizando alta disponibilidad y descubrimiento automático.
Balanceo de Carga:

Dos instancias del Microservicio de Productos se ejecutaron en puertos distintos.
Se simuló un flujo de peticiones constantes con Postman, verificando la distribución equitativa de las solicitudes.
Circuit Breaker y Retry:

Implementado mediante Resilience4J.
Se añadieron métodos de fallback para garantizar la continuidad del servicio ante fallos y configuraciones de reintento automático con la anotación @Retry.
API Gateway:

Desarrollada con Spring Cloud Gateway para actuar como intermediario entre los clientes y los microservicios.
Configuración centralizada para enrutar las solicitudes hacia los servicios correspondientes.
Dockerización y Deploy:

Se crearon Dockerfiles específicos para cada servicio y un archivo docker-compose.yml que define su ejecución conjunta.
Los servicios se desplegaron en un entorno Docker. Se validó exitosamente la comunicación interna entre ellos mediante pruebas en Postman.
Pruebas y Validación: El proyecto fue probado exhaustivamente para garantizar la robustez y confiabilidad de la arquitectura. Mediante Postman, se verificaron:

La correcta funcionalidad de los CRUDs.
La distribución de carga en el Microservicio de Productos.
La recuperación ante fallos gracias al Circuit Breaker.
La comunicación entre los servicios a través de la API Gateway en el entorno de Docker.
