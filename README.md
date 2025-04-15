# 📈 Trading Platform Service
Trading Platform Service es una aplicación RESTful desarrollada en **Java con Spring Boot**, orientada a la gestión de traders. Implementa una arquitectura **multicapa** basada en principios de **Domain-Driven Design (DDD)** y se conecta a una base de datos **PostgreSQL** para el almacenamiento persistente de datos.

# 🚀 Tecnologías utilizadas
- Spring Boot.
- Spring Data JPA.
- Spring Security.
- MapStruct.
- PostgreSQL-

# ⚙️ Funcionalidades

1. **Crear cuenta de trader**
  - Permite registrar un nuevo trader.
  - Se valida la entidad para evitar datos nulos o inválidos.
  - Si el correo electrónico ya está registrado, retorna HTTP 400 (Bad Request).
  - En caso exitoso, retorna HTTP 201 (Created).

2. **Modificar cuenta de trader**
  - Actualiza la información de un trader existente.
  - Se permite modificar únicamente el nombre o el correo electrónico.
  - Si el trader no se encuentra por el correo proporcionado, retorna HTTP 404 (Not Found).
  - Si se actualiza correctamente, retorna HTTP 200 (OK).

3. **Agregar dinero a una cuenta**
  - Aumenta el saldo disponible de un trader identificado por su correo.
  - Si el trader no se encuentra, retorna HTTP 404 (Not Found).
  - En caso exitoso, retorna HTTP 200 (OK).

4. **Consultar todos los traders**
  - Devuelve una lista de todos los traders registrados en formato JSON.
  - Los resultados están ordenados alfabéticamente por nombre (ascendente).
  - Retorna HTTP 200 (OK).
    
5. **Consultar trader por correo electrónico**
  - Devuelve la información del trader correspondiente al correo proporcionado.
  - Si el trader no existe, retorna HTTP 404 (Not Found).
  - En caso exitoso, retorna HTTP 200 (OK).

# ✅ Requisitos del entorno
  - Java 17+
  - Gradle
  - PostgreSQL 13+
  - IDE compatible (IntelliJ, Eclipse, VSCode)


