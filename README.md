# Retail Ecommerce - Sistema de Reserva de Despacho

Este proyecto es una solución técnica para el desafío de Ventanas de Despacho con Cobertura Geográfica.Implemente un sistema completo de e-commerce que permite la navegación de productos, gestión de carrito y la reserva de bloques horarios de entrega validando stock y capacidad en tiempo real

## Características Principales

### Backend
*API RESTful: Endpoints para cálculo de precios, gestión de slots y validación de reservas.
* Gestión de Capacidad: Control estricto de cupos por ventana horaria para evitar sobre-venta.
* Base de Datos en Memoria (H2): Persistencia volátil para facilitar la ejecución y pruebas sin configuraciones externas.
* Carga de Datos Automática: El sistema inicia con un catálogo de productos y ventanas de despacho pre-cargadas.

### Frontend
* Interfaz de Usuario Responsiva: Diseño inspirado en la experiencia de usuario real de retail.
* Filtros Dinámicos: Filtrado por Categoría, Marca y Búsqueda por texto.
* Experiencia de Checkout: Flujo completo desde el agregado al carro hasta la selección de fecha/hora y confirmación de pago.
* Imágenes Dinámicas: Integración con servicios de imágenes para visualizar productos acorde a su categoría.

## Tecnologías Utilizadas

* Lenguaje: Java 17+ 
* Framework: Spring Boot 3.x (Web, JPA) 
* Base de Datos: H2 Database (Memoria)
* Build Tool: Maven
* Frontend: HTML5, CSS3, JavaScript (Vanilla)

## Instrucciones de Ejecución

Sigan estos pasos para levantar el proyecto en tu entorno local. No se requiere configuración de base de datos externa.

### Prerrequisitos
* Java JDK 17 o superior instalado.
* Maven instalado (o usar el wrapper mvnw incluido).

### Paso 1: Clonar el Repositorio

git clone <URL_DE_TU_REPOSITORIO>
cd ecommerce-challenge

### Paso 2: Ejecutar el Backend
Desde la terminal en la raíz del proyecto, ejecuta:

./mvnw spring-boot:run

O si tienes Maven instalado:

mvn spring-boot:run

El servidor iniciará en el puerto 9090.

### Paso 3: Ejecutar el Frontend
El frontend es una aplicación web estática que consume la API del backend.

1. Ve a la carpeta donde está el archivo index.html.
2. Haz doble clic en index.html para abrirlo en tu navegador.

## Decisiones de Diseño y Concurrencia

### Modelo de Dominio
Se definieron las siguientes entidades principales:
* Product: Representa el ítem en venta (SKU, precio, marca).
* DeliverySlot: Representa una ventana de tiempo específica (Fecha, Hora Inicio, Hora Fin) con una capacidad finita.

### Manejo de Concurrencia
El desafío requiere garantizar consistencia bajo concurrencia para evitar que usuarios reserven el mismo cupo simultáneamente.

Estrategia Implementada:
Para esta prueba de concepto, se implementó un control de concurrencia mediante synchronized en el método de reserva del servicio y validaciones atómicas en memoria.

Propuesta para Producción:
En un entorno productivo real con múltiples instancias, la solución propuesta sería:

1. Bloqueo Pesimista en Base de Datos:
Utilizar SELECT ... FOR UPDATE al consultar el slot disponible. Esto bloquea la fila de la base de datos hasta que la transacción termina.

2. Manejo de Inventario Atómico (Redis):
Utilizar Redis con operaciones de decremento atómico para manejar el stock de los slots de despacho, lo cual es rápido y seguro para entornos distribuidos.

## Documentación API

1. Obtener Productos
GET /api/products
Parámetros opcionales: ?category=Hogar&brand=Samsung

2. Calcular Checkout
POST /api/checkout/calculate
Body:
{
  "productIds": [1, 2],
  "paymentMethod": "DEBITO",
  "deliveryWindow": "09:00 - 13:00"
}
