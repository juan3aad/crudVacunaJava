-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-12-2021 a las 15:24:53
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `unapoo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionario`
--

CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Registra los dato de funcionario';

--
-- Volcado de datos para la tabla `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `cedula`, `nombre`, `apellidos`, `email`, `telefono`) VALUES
(9, '100', 'Erismeldy', 'Castillo', 'eri@gmial.com', '01/02/1980'),
(10, '101', 'Liset', 'tovar', 'tovar@gmail.com', '456789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `idLogin` int(11) NOT NULL,
  `funcionarioId` int(11) DEFAULT NULL,
  `login` varchar(40) DEFAULT NULL,
  `pass` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Registra los datos del registro Login';

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`idLogin`, `funcionarioId`, `login`, `pass`) VALUES
(1, 9, 'emssa', 'emssa'),
(3, 9, 'root', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `fechaNacimiento` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Registra los datos del Paciente';

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `cedula`, `nombre`, `apellidos`, `email`, `telefono`, `fechaNacimiento`) VALUES
(1, '100', 'Lucy yy', 'De Arcos', 'luci@gmail.com', '789895', '2021-09-14 00:00:00'),
(2, '200', 'jose', 'ramon', 'ramon@gmail.com', '78955', '2021-09-14 18:35:19'),
(3, '300', 'Jaime', 'Solarte', 'jaine@gmail.com', '789654', '2021-09-14 18:35:19'),
(4, '400', 'Eduardi', 'Solarte', 'edu@gmail.com', '7895552', '2021-09-14 18:35:19'),
(5, '333', 'Duban', 'Solarte', 'dubangmail.com', '34589674', '2021-09-14 18:35:19'),
(6, '500', 'Diana', 'Soto', 'soto@gmail.com', '3117042594', '2021-09-14 18:35:19'),
(7, '600', 'Daniela', 'perez', 'dani@gmail.com', '7345623', '2021-09-14 18:35:19'),
(8, '666', 'Luciana', 'Gomez', 'kuci@gmail.com', '345672', '2021-09-14 18:35:19'),
(9, '5555', 'Manuel', 'Villa', 'manu@gmail.com', '7234567', '2021-09-14 18:35:19'),
(10, '666', 'Luciana', 'Gomez', 'kuci@gmail.com', '345672', '2021-09-14 18:35:19'),
(11, '3456', 'Camilo', 'Suarez', 'su@gmail.com', '7653423', '2000-05-01 00:00:00'),
(12, '56789', 'dayana', 'mezon', 'day@gmail.com', '456789', '1983-01-05 00:00:00'),
(13, '104', 'Lucy', 'Arcos', 'luci@gmail.com', '789895', '2021-09-14 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrovacuna`
--

CREATE TABLE `registrovacuna` (
  `idregistroVacuna` int(11) NOT NULL,
  `fechavacuna` date DEFAULT NULL,
  `pacienteId` int(11) DEFAULT NULL,
  `vacunaId` int(11) DEFAULT NULL,
  `funcionarioId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Registra los datos del registro Vacuna';

--
-- Volcado de datos para la tabla `registrovacuna`
--

INSERT INTO `registrovacuna` (`idregistroVacuna`, `fechavacuna`, `pacienteId`, `vacunaId`, `funcionarioId`) VALUES
(1, '2021-11-02', 5, 1, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `idVacuna` int(11) NOT NULL,
  `nombreVacuna` varchar(45) DEFAULT NULL,
  `lote` varchar(45) DEFAULT NULL,
  `fechaVencimiento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Registra los datos de la Vacuna';

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`idVacuna`, `nombreVacuna`, `lote`, `fechaVencimiento`) VALUES
(1, 'Sinova', 'L20', '2021-11-02');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idLogin`),
  ADD KEY `funcionarioId` (`funcionarioId`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`);

--
-- Indices de la tabla `registrovacuna`
--
ALTER TABLE `registrovacuna`
  ADD PRIMARY KEY (`idregistroVacuna`),
  ADD KEY `pacienteId` (`pacienteId`),
  ADD KEY `vacunaId` (`vacunaId`),
  ADD KEY `funcionarioId` (`funcionarioId`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`idVacuna`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `idLogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `registrovacuna`
--
ALTER TABLE `registrovacuna`
  MODIFY `idregistroVacuna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `idVacuna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`funcionarioId`) REFERENCES `funcionario` (`idFuncionario`);

--
-- Filtros para la tabla `registrovacuna`
--
ALTER TABLE `registrovacuna`
  ADD CONSTRAINT `registrovacuna_ibfk_1` FOREIGN KEY (`pacienteId`) REFERENCES `paciente` (`idPaciente`),
  ADD CONSTRAINT `registrovacuna_ibfk_2` FOREIGN KEY (`vacunaId`) REFERENCES `vacuna` (`idVacuna`),
  ADD CONSTRAINT `registrovacuna_ibfk_3` FOREIGN KEY (`funcionarioId`) REFERENCES `funcionario` (`idFuncionario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
