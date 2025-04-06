CREATE TABLE trader(
   "id" INT NOT NULL,
   "name" VARCHAR(140) NOT NULL,
   "email" VARCHAR(70) NOT NULL,
   "balance" DECIMAL(20,2) NOT NULL,
   "created_at" TIMESTAMP NOT NULL,
   "updated_at" TIMESTAMP NULL,
   PRIMARY KEY("id")
);