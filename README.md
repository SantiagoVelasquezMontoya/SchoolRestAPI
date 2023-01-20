# SchoolRestAPI


*Port: 8087*
*Nombre de la base de datos: santiagoV*

Http Requests:

### Alumni (GET,POST,PUT,DELETE)
* http://localhost:8087/alumni
Recibe un body asi para crear:  
```
{
    "id": 1,
    "firstname": "Santiago",
    "lastname": "Velasquez",
    "birthdate": "2/06/1997",
    "age" : 25
}
```


### Teacher (GET,POST,PUT,DELETE)
* http://localhost:8087/teacher 
Aun falta calcular edad a traves de fecha de nacimiento <br/>
Recibe un body asi para crear: 
```
{
    "id": 1,
    "firstname": "Cristian",
    "lastname": "Agudelo",
    "birthdate": "1/1/1",
    "age" : 1
}
 ```


### Assignature (GET, POST)
* http://localhost:8087/assignature
Recibe un body asi para crear: 
```
{
    "id": 1,
    "schedule" : "2 PM",
    "topic" : "Science"
}
```


### Assignature (POST)

Esta URI se usa para Agregar un Maestro a una Materia
* http://localhost:8087/assignature/teacher
Recibe un body asi:
```
{
    "teacherId" : 1,
    "assignatureId" : 1
}
```





