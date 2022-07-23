CREATE USER 'risk-prev'@'localhost' IDENTIFIED BY '@1g/4c#F2$_m';

CREATE SCHEMA `risk_prev_DB` DEFAULT CHARACTER SET utf8mb4;

GRANT ALL PRIVILEGES ON risk_prev_DB. * TO 'risk-prev'@'localhost';

CREATE TABLE `risk_prev_DB`.`capacitaciones` (
  `id_capacitaciones` INT NOT NULL AUTO_INCREMENT,
  `rut_cliente` VARCHAR(12) NOT NULL,
  `dia_capacitacion` VARCHAR(10) NOT NULL,
  `hora_capacitacion` VARCHAR(5) NOT NULL,
  `lugar_capacitacion` VARCHAR(45) NOT NULL,
  `duracion_capacitacion` VARCHAR(15) NOT NULL,
  `cantidad_asistentes` INT NOT NULL,
  PRIMARY KEY (`id_capacitaciones`));

CREATE TABLE `risk_prev_DB`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` VARCHAR(45) NOT NULL,
  `run` VARCHAR(12) NOT NULL,
  `tipo_usuario` ENUM('admin', 'cliente', 'pro') NULL,
  PRIMARY KEY (`id_usuario`));

CREATE TABLE `risk_prev_DB`.`clientes` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `rut` VARCHAR(12) NULL,
  `nombres` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `afp` VARCHAR(45) NULL,
  `sistema_salud` INT NULL,
  `direccion` VARCHAR(45) NULL,
  `comuna` VARCHAR(45) NULL,
  `edad` INT NULL,
  `id_usuario` INT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_usuario_client_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_client`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `risk_prev_DB`.`usuarios` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
  
  CREATE TABLE `risk_prev_DB`.`administrativos` (
  `id_administrativo` INT NOT NULL AUTO_INCREMENT,
  `area` VARCHAR(45) NOT NULL,
  `experiencia_previa` VARCHAR(45) NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_administrativo`),
  INDEX `fk_usuario_admin_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_admin`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `risk_prev_DB`.`usuarios` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `risk_prev_DB`.`profesionales` (
  `id_profesional` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `fecha_ingreso` VARCHAR(45) NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_profesional`),
  INDEX `fk_usuario_pro_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_pro`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `risk_prev_DB`.`usuarios` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


INSERT INTO capacitaciones(rut_cliente, dia_capacitacion, hora_capacitacion, lugar_capacitacion, duracion_capacitacion, cantidad_asistentes)
VALUES ("14.888.666-4", "Lunes", "10:30", "Valparaíso", "45", 25),
("18.232.545-7", "Martes", "09:00", "Viña del Mar", "90", 20),
("17.765.098-k", "Jueves", "14:00", "Quilpué", "60", 30);

INSERT INTO usuarios(nombre_usuario, fecha_nacimiento, run)
VALUES ("JuanPérez82", "1982-05-12", "13.544.788-7"),
("Dr. Polo", "1978-10-19", "11.334.545-k"),
("Rosa Espinoza", "1986-12-31", "16.478.290-1");

INSERT INTO clientes(rut, nombres, apellidos, telefono, afp, sistema_salud, direccion, comuna, edad, id_usuario)
VALUES ("13.544.788-7", "Juan Mauricio", "Pérez Soto", "+56944556699", "Provida", 1, "Calle La Calle s/n", "Nunca Jamás", 40, 1);

INSERT INTO administrativos(area, experiencia_previa, id_usuario)
VALUES ("Hotelería", "4 años en administración gastronómica", 3);

INSERT INTO profesionales(titulo, fecha_ingreso, id_usuario)
VALUES ("Médico Forense", "2022-06-21", 2);
