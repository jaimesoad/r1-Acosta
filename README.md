# r1-Acosta

## Ejecución:
Para conectar la base de datos, es necesario añadir los 
datos necesarios para que pueda conectarse en el archivo
`application.properties` en la carpeta `src/main/resources`.
Las variables son las siguientes:
 - Los datos a cabiarse son **host_de_la_DBMS** y **Nombre_de_la_BD** (el puerto puede cambiarse de ser necesario).
```properties
spring.datasource.url=jdbc:mysql://*host_de_la_DBMS*:3306/*Nombre_de_la_BD*
```
 - El usuario de la base de datos:
```properties
spring.datasource.username=
``` 
 - La contraseña de la base de datos:
```properties
spring.datasource.password=
```

## Endpoints
Los endpoints que toman valores del body son el POST y el PUT, por lo cual
es necesario conocer los valores que estos toman como entrada.

### POST
El Post toma como valores `nombreCliente` que es de tipo string y 
`saldo` que es de tipo numérico.\
 - Ejemplo:
```json
{
  "nombreCliente": "Juan",
  "saldo": 200
}
```

### PUT
El Put toma únicamente los el valor de `saldo`, siendo este numérico.
 - Ejemplo:
```json
{
  "saldo": 20
}
```