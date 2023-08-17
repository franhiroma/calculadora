# Prueba Calculadora

Microservicio para una calculadora que expone una interfaz REST para realizar sumas y restas de dos parámetros.

## Autor

Francisco J. de la Higuera Rodríguez-Madridejos

## API Calculadora

- **URL:** `http://localhost:8080/calculadora/v1/operacion`
- **Método:** POST
- **Cuerpo de la Solicitud (SUMAR):**

```json
{
    "numero1": 5.0,
    "numero2": 3.0,
    "operacion": "SUMAR"
}

```

- **Cuerpo de la Solicitud (RESTAR):**

```json
{
    "numero1": 5.0,
    "numero2": 3.0,
    "operacion": "RESTAR"
}

```

- **Cuerpo de la respuesta:**

```json
{
    "resultado": 2.0
}

```




