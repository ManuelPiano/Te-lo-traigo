# Te-lo-traigo APP

Esta aplicación está diseñada para realizar cotizaciones y consta de cuatro partes principales:

- Cliente
- Producto
- Tipo de producto
- Cotización

La aplicación está desarrollada en Java Spring y documentada utilizando Swagger.

## Acceso a Swagger

Puedes acceder a la documentación de la API utilizando Swagger a través de la siguiente dirección:
[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

![Swagger UI](https://github.com/ManuelPiano/Te-lo-traigo/assets/101200587/7ef999a6-d34f-4c37-a2e3-39bace5f0a4e)

## Instrucciones para ejecutar el proyecto

1. Crea una base de datos en MySQL llamada `pruebaDevintech`.

2. Configura las credenciales de la base de datos en el archivo `application.properties`:

   ```properties
   spring.datasource.username=tu-usuario
   spring.datasource.password=tu-contraseña


También puedes clonar este proyecto directamente desde GitHub usando el siguiente comando: 

`git clone https://github.com/ManuelPiano/Te-lo-traigo.git`

## Realizar una Cotización

¡Te Lo Traigo! permite calcular cotizaciones de importación de productos a través de su API. Sigue estos pasos para hacer una cotización:

1. **Acceder a Swagger**: Ve a [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/) en tu navegador para abrir la interfaz de Swagger.

2. **Autenticación**: Si es necesario, asegúrate de estar autenticado en Swagger para realizar solicitudes.

3. **Seleccionar el Endpoint de Cotización**:

   - Encuentra el endpoint `Quotation/Create` en la sección `quotations-controller` y haz clic en él.

4. **Enviar una Solicitud de Cotización**:

   - Presiona el botón "Try it out".
   - En la sección "Request body", copia y pega el siguiente JSON:

     ```json
     {
       "clientId": 1,
       "productId": 2
     }
     ```

     Nota: Reemplaza los valores `clientId` y `productId` con los IDs reales del cliente y el producto que deseas cotizar.

5. **Ejecutar la Solicitud**:

   - Haz clic en el botón "Execute". Esto enviará la solicitud de cotización a la API.

6. **Ver la Respuesta de Cotización**:

   - Desplázate hacia abajo en la página para ver la respuesta de la API. Un ejemplo de respuesta podría ser:

     ```json
     {
       "id": 1,
       "client": {
         "id": 1,
         "name": "Juan Perez",
         "email": "juan.perez@example.com"
       },
       "productType": {
         "id": 2,
         "name": "Electrónicos",
         "shippingPercentage": 0.1,
         "importFeesPercentage": 0.2,
         "insurancePercentage": 0.05,
         "taxesPercentage": 0.15
       },
       "product": {
         "id": 2,
         "name": "Laptop",
         "price": 800,
         "weight": 2.5
       },
       "shippingCost": 20,
       "importFeesCost": 160,
       "insuranceCost": 40,
       "taxesCost": 120,
       "totalImportCost": 340,
       "totalProductAndImportCost": 1140
     }
     ```

´

Notas adicionales
Asegúrate de que tienes Java y Maven instalados en tu sistema antes de ejecutar el proyecto.
La aplicación utiliza Spring Boot, lo que hace que la configuración y ejecución sean sencillas.
¡Disfruta explorando y probando la aplicación!

