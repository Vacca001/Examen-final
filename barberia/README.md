# 🧔‍♂️ BarberPro - Sistema de Reservas para Barbería

## 👥 Integrantes del Grupo
- **Darlin Eliuth Vacca Navarro - 191981** – Desarrollador del Codigo.
- **[Ronaldo Sanchez Claro - 192308]** – [Documentacion ].
- **[Jose Fernado Mejia - 191282]** – [Desarrolador del codigo ]. 
- **[Ronaldo Sanchez Claro - 192308]** – [Documentacion ].

---

## 🧩 Descripción del Proyecto

**BarberPro** es una aplicación de escritorio desarrollada en Java que permite gestionar de forma sencilla las reservas en una barbería. El sistema automatiza el registro de clientes, barberos, servicios disponibles y agendamiento de citas mediante un menú interactivo por consola.

---

## 🎯 Problema y Solución

**Problema:**
Las barberías pequeñas suelen gestionar citas en papel, lo que genera errores, pérdida de información y falta de organización.

**Solución:**
BarberPro digitaliza el proceso con:
- Almacenamiento seguro de datos (clientes, barberos, servicios).
- Agenda de citas con validación de horarios.
- Interfaz intuitiva por consola.

---

## ⚙️ Clases Principales

| Clase         | Descripción                                                                 |
|---------------|-----------------------------------------------------------------------------|
| `Persona`     | Clase base con atributos comunes (nombre, cédula) para `Cliente` y `Barbero`. |
| `Cliente`     | Gestiona información de clientes (ID único, nombre, cédula).               |
| `Barbero`     | Almacena datos de barberos y su especialidad.                              |
| `Servicio`    | Define servicios disponibles (ej. "Corte premium", precio).                |
| `Cita`        | Relaciona cliente, barbero, servicio, fecha y hora.                        |
| `Utilidades`  | Métodos reutilizables para validación de entradas (texto, números, fechas).|
| `Main`        | Clase principal con el menú interactivo y lógica central.                  |

---

## 🔄 Lógica Implementada

### ✔️ Programación Orientada a Objetos
- **Herencia:** `Cliente` y `Barbero` heredan de `Persona`.
- **Encapsulamiento:** Uso de `private` y métodos `getters` en todas las clases.
- **Estructuras de datos:** `ArrayList` para gestionar clientes, barberos, servicios y citas.

### ✔️ Flujo del Programa
- **Condicionales:** `if/else` y `switch` para el menú y validaciones.
- **Bucles:** `while` para el menú principal y `for` para listar elementos.
- **Métodos reutilizables:**
  - `leerEntero()`, `leerTexto()`, `leerFecha()` (en `Utilidades`).
  - `seleccionarElemento()` y `citaExistente()` (en `Main`).

### ✔️ Manejo de Excepciones
- Validación de entradas con `try/catch` (ej: números enteros en `leerEntero()`).
- Control de formatos (fechas `dd/mm/aaaa`, horas `hh:mm`).

---

## 📸 Capturas de Pantalla *

![Menú principal](imagenes/1.png)
![Registro de cliente](imagenes/2.png)
![Agenda de citas](imagenes/3.png)


