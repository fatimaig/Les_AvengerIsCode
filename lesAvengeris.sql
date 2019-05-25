-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
--
-- Base de datos: `les_avengeris`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disenos`
--
CREATE TABLE IF NOT EXISTS disenos(
	idDiseno int(11) NOT NULL AUTO_INCREMENT,
	nombre varchar(20) NOT NULL,
	descripcion varchar(200),
	propietario int(11) NOT NULL,
	alto float NOT NULL,
	ancho float NOT NULL,
	profundidad float NOT NULL,
	precio float NOT NULL,
	archivo varchar(50) NOT NULL,
	activo tinyint(1) NOT NULL,
	PRIMARY KEY (idDiseno)
);

--
-- Estructura de tabla para la tabla `impresora`
--
CREATE TABLE IF NOT EXISTS impresora(
	idImpresora int(11) NOT NULL AUTO_INCREMENT,
	nombre varchar(20) NOT NULL,
	alto float NOT NULL,
	ancho float NOT NULL,
	profundidad float NOT NULL,
	usuario int(11) NOT NULL,
	activo tinyint(1) NOT NULL,
	PRIMARY KEY (idImpresora)
);

--
-- Estructura de tabla para la tabla `locales`
--


CREATE TABLE IF NOT EXISTS locales (
  IdLocal int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(20) NOT NULL,
  telefono int(11) NOT NULL,
  CIF int(11) NOT NULL,
  direccion varchar(30) NOT NULL,
  CP int(11) NOT NULL,
  localidad varchar(20) NOT NULL,
  representante varchar(25) NOT NULL,
  activo tinyint(1) NOT NULL, 
  PRIMARY KEY (IdLocal)
 
);


--
-- Estructura de tabla para la tabla 'usuario' 

CREATE TABLE IF NOT EXISTS usuario (
  idUsuario int(5) NOT NULL AUTO_INCREMENT,
  nombre varchar(20) NOT NULL,
  apellidos varchar(40) NOT NULL,
  email varchar(40) NOT NULL,
  fechaNacimiento date NOT NULL,
  direccion varchar(40) NOT NULL,
  contrasenna varchar(25) NOT NULL,
  titularCuenta varchar (25) NOT NULL,
  cuentaBancaria varchar(16) NOT NULL,
  fechaCaducidad date NOT NULL,
  activo tinyint(1) NOT NULL, 
  PRIMARY KEY(idUsuario)
  
  
);


--
-- Ã�ndices para tablas volcadas