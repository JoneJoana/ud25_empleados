U25_Empleados

api departamentos

GET:

localhost:8080/api/departamentos  -ALL

localhost:8080/api/departamentos/{id}  -mostrar por id

localhost:8080/api/departamentos/nombre/{nombre}  -mostrar por nombre


POST:

localhost:8080/api/departamentos  -crear nuevo (requiere bodyJson)


PUT:

localhost:8080/api/departamentos/{id}  -actualiza el elemento indicado


DELETE:

localhost:8080/api/departamentos/{id} 


-----------------

API Empleados

GET:

localhost:8080/api/empleados  -ALL

localhost:8080/api/empleados/{dni}  -mostrar por id

localhost:8080/api/empleados/nombre/{nombre}  -mostrar por nombre

localhost:8080/api/empleados/departamento/{departamento}  -busqueda de empleados por departamento



POST:

localhost:8080/api/empleados  -crear nuevo (requiere bodyJson)


PUT:

localhost:8080/api/empleados/{dni}  -actualiza el elemento indicado


DELETE:

localhost:8080/api/empleados/{dni} 