# SchoolRestAPI


*Port: 8087*

Http Requests:

### Alumni (GET,POST,PUT,DELETE)

Recibe un body asi para crear:  

{
    "id": 1,
    "firstname": "Santiago",
    "lastname": "Velasquez",
    "birthdate": "2/06/1997",
    "age" : 25
}

* http://localhost:8087/alumni

### Teacher (GET,POST,PUT,DELETE)
Aun falta calcular edad a traves de fecha de nacimiento;
Recibe un body asi para crear: 

{
    "id": 1,
    "firstname": "Cristian",
    "lastname": "Agudelo",
    "birthdate": "1/1/1",
    "age" : 1
}
 
* http://localhost:8087/teacher 

### Assignature (GET, POST)

Recibe un body asi para crear: 

{
    "id": 1,
    "schedule" : "2 PM",
    "topic" : "Science"
}

* http://localhost:8087/assignature

### Assignature (POST)

Esta URI se usa para Agregar un Maestro a una Materia

Recibe un body asi:
{
    "teacherId" : 1,
    "assignatureId" : 1
}

* http://localhost:8087/assignature/teacher




