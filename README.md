# Calculadora de ventas de Wtech

Sistema en Java que calcula el valor de un pedido de productos tecnológicos (subtotal, costo de envío y total) usando el patrón de diseño Visitor.

Los productos (tablet, portátil, computadora de torre y televisión) solo almacenan sus datos. Las reglas de negocio, como el subtotal y el envío, viven en visitantes independientes. Así, agregar una nueva regla (impuestos, descuentos, reportes) solo requiere crear un nuevo visitante, sin modificar las clases de producto.
## Salida en pantalla

<img width="521" height="187" alt="image" src="https://github.com/user-attachments/assets/fbce5542-ef80-4042-9f90-959f26945f8c" />

El pedido de prueba contiene 2 tablets, 1 portátil, 1 computadora de torre y 1 televisión.
## Cómo funciona

1. Cada producto implementa `aceptar(v)` llamando a `v.visitar(this)` (doble despacho), por lo que el producto indica qué método del visitante corresponde.
2. `Pedido` guarda los productos con su cantidad y los recorre aplicando el visitante recibido.
3. Cada visitante acumula su propio resultado, por lo que se crea una instancia nueva por cada cálculo.

### Regla de envío

```
porcentajeEnvio = (pesoEnGramos / 100) * 2
costoEnvio      = precio * porcentajeEnvio / 100
```

