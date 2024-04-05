# AREP-Parcial-2


### Arquitectura

Este proyecto cuenta con la siguiente arquitectura en la nube:

![img.png](Images/img_2.png)

Donde cada uno de los elementos cumple las siguientes funciones:

#### Service Proxy

Recibe las solicitudes de llamado desde los clientes y se las delega a las dos instancias del servicio de ordenamiento
usando un algoritmo de round-robin

#### Math Services

Este servicio recibe peticiones con los datos ``(lista, valor)``, done implementa dos algoitmos de búsqueda diferentes,
Linear search y binary search.

### Pruebas

Para Probar el servicio, se ingresa a la url:
~~~
http://localhost:4566/index.html
~~~
Y se ingresa la lista de valores y el valor a buscar, tenga en cuenta que para el Binary search debe escribir la lista
de elementos ordenada de menor a mayor

![img.png](Images/img.png

