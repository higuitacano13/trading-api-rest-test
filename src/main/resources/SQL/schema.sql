CREATE TABLE trader(
   "id" INT NOT NULL,
   "name" VARCHAR(140) NOT NULL,
   "email" VARCHAR(70) NOT NULL,
   "balance" DECIMAL(20,2) NOT NULL,
   "created_at" TIMESTAMP NOT NULL,
   "updated_at" TIMESTAMP NULL,
   PRIMARY KEY("id")
);

-- Elimina la restricción NOT NULL primero si es necesario
ALTER TABLE trader
    ALTER COLUMN id DROP DEFAULT;

-- Convierte 'id' en una columna autogenerada (PostgreSQL 10+)
ALTER TABLE trader
ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY;
