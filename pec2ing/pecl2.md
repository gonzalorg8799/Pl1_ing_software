<div align="center">

# UNIVERSIDAD DE ALCALÁ
## Grado en Ingeniería en Sistemas de Información (GISI)
### Ingeniería del Software - Curso 2025/2026

<br><br><br>

# PECL 2: Laboratorio
### Pruebas de Software y Análisis de Métricas


<br><br>

**Autores**
* Gonzalo Rodríguez Castro
* David Salgado Soltero

<br><br>

**Fecha:** 06/05/2026

</div>
<div style="page-break-after: always;"></div>


---

# Índice
1. [Ejercicio 1: Diseño de las pruebas para el método binarySearch](#ejercicio-1)
   - 1.1 Complejidad Ciclomática
   - 1.2 Tabla de casos de prueba
2. [Ejercicio 2: Diseño de los casos de prueba para el método evaluarCliente](#ejercicio-2)
   - 2.1 Tabla de clases de equivalencia y valores límite
3. [Ejercicio 3: Análisis de métricas de JChecs](#ejercicio-3)
   - 3.1 Análisis con JavaNCSS y CKJM
   - 3.2 Valoración de mantenimiento

---

## Ejercicio 2
### <u>Complejidad Ciclómatica</u>
![Texto alternativo](1.png)

Para el método binarySearch, la complejidad la calculamos contando las decisiones:

<u>Decisiones:</u> 1 while, 1 if, 1 Else if = 1 + 1 + 1 = 3

<u>Fórmula:</u> nº decisiones + 1 = 4.

Cómo el resultado de la fórmula de la complejidad ciclomática es 4 sabesmos que al menos necesitamos al menos 4 cassos de prueba para poder cubrir todos los caminos independientes.

### <u>Tabla de casos de prueba</u>

| ID | Valor X | Array A | Resultado esperado |
-----|----------|---------|-------------------|
| CP1| 5 | {} | -1 |
| CP2| 3 | {1,3,5}|1|
| CP3| 1 | {1,3,5}|0|
| CP4| 5 | {1,3,5}|2|


![Texto alternativo](2.png)

## Ejercicio 3

Para este ejercicio utilizamos la técnica de Clases de equivalencia y valores límite sobre el método dentro de cajero automático.

### <u>Tabla de clases de equivalencia</u>

![Texto alternativo](3.png)

| Parámetro | Clase válida | Clases inválidas |
--------|--------|----------|
| Cantidad | 0<= x <= 200.000 | x > 200.000|
| Plazo | 0<= x <= 240 | x > 240 |
| Edad | x <= 50 | x > 50 |

Sabemos que los parametros que tenemos que testear son 3 y tienen una opción válida y una inválida, entoces para calcular la cantidad de pruebas que tenemos que realizar podríamos calcularla de tal forma 2^3 = 8 TEST.

![Texto alternativo](4.png)