# U25_Empleados

## API departamentos

### GET:
```
ud25-empleados.herokuapp.com/api/departamentos  -ALL

ud25-empleados.herokuapp.com/api/departamentos/{id}  -mostrar por id

ud25-empleados.herokuapp.com/api/departamentos/nombre/{nombre}  -mostrar por nombre
```

### POST:
```
ud25-empleados.herokuapp.com/api/departamentos  -crear nuevo (requiere bodyJson)
```

### PUT:
```
ud25-empleados.herokuapp.com/api/departamentos/{id}  -actualiza el elemento indicado
```

### DELETE:
```
ud25-empleados.herokuapp.com/api/departamentos/{id} 
```


## API Empleados

### GET:
```
ud25-empleados.herokuapp.com/api/empleados  -ALL

ud25-empleados.herokuapp.com/api/empleados/{dni}  -mostrar por id

ud25-empleados.herokuapp.com/api/empleados/nombre/{nombre}  -mostrar por nombre

ud25-empleados.herokuapp.com/api/empleados/departamento/{departamento}  -busqueda de empleados por departamento
```

### POST:
```
ud25-empleados.herokuapp.com/api/empleados  -crear nuevo (requiere bodyJson)
```

### PUT:
```
ud25-empleados.herokuapp.com/api/empleados/{dni}  -actualiza el elemento indicado
```

### DELETE:
```
ud25-empleados.herokuapp.com/api/empleados/{dni} 
```
