-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: 21-Jul-2019 às 04:04
-- Versão do servidor: 10.2.15-MariaDB-log
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `acme`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `TB_AGENDAMENTOS`
--

CREATE TABLE `TB_AGENDAMENTOS` (
  `ID` int(11) NOT NULL,
  `ID_MEDICO` int(11) NOT NULL,
  `ID_PACIENTE` int(11) NOT NULL,
  `DATA_AGENDAMENTO` datetime NOT NULL,
  `DATA_CONSULTA` datetime NOT NULL,
  `STATUS` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `TB_CONTATOS`
--

CREATE TABLE `TB_CONTATOS` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `TELEFONE` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `TB_CONTATOS`
--

INSERT INTO `TB_CONTATOS` (`ID`, `NOME`, `EMAIL`, `TELEFONE`) VALUES
(1, 'Carlos Barbosa Gomes Filho', 'cbarbosagomesfilho@gmail.com', '83991267778'),
(3, 'Ricardo Belo', 'contato@ricardobelo.com.br', '131232121321');

-- --------------------------------------------------------

--
-- Estrutura da tabela `TB_MEDICOS`
--

CREATE TABLE `TB_MEDICOS` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `TELEFONE` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `TB_MEDICOS`
--

INSERT INTO `TB_MEDICOS` (`ID`, `NOME`, `EMAIL`, `TELEFONE`) VALUES
(1, 'Dr. Carlos Barbosa', 'cbarbosagomesfilho@gmail.com', '83991267778');

-- --------------------------------------------------------

--
-- Estrutura da tabela `TB_PACIENTES`
--

CREATE TABLE `TB_PACIENTES` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `TELEFONE` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `TB_PACIENTES`
--

INSERT INTO `TB_PACIENTES` (`ID`, `NOME`, `EMAIL`, `TELEFONE`) VALUES
(1, 'Carlos Barbosa Gomes Filho', 'cbarbosagomesfilho@gmail.com', '83991267778'),
(3, 'Ricardo Belo', 'contato@ricardobelo.com.br', '131232121321');

-- --------------------------------------------------------

--
-- Estrutura da tabela `TB_USUARIOS`
--

CREATE TABLE `TB_USUARIOS` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `LOGIN` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `TELEFONES` varchar(100) NOT NULL,
  `SENHA` varchar(100) NOT NULL,
  `ATIVO` tinyint(1) DEFAULT NULL,
  `ADMINISTRADOR` tinyint(1) DEFAULT NULL,
  `VISITANTE` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `TB_USUARIOS`
--

INSERT INTO `TB_USUARIOS` (`ID`, `NOME`, `LOGIN`, `EMAIL`, `TELEFONES`, `SENHA`, `ATIVO`, `ADMINISTRADOR`, `VISITANTE`) VALUES
(2, 'Carlos Barbosa', 'cbgomes', 'cbgomes@gmail.com', '00000000', '827CCB0EEA8A706C4C34A16891F84E7B', 1, 0, 0),
(4, 'Ricardo Belo', 'belo', 'aaaassd@ricardobelo.com.br', '21312321312', '200820E3227815ED1756A6B531E7E0D2', 0, 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `TB_AGENDAMENTOS`
--
ALTER TABLE `TB_AGENDAMENTOS`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `TB_CONTATOS`
--
ALTER TABLE `TB_CONTATOS`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `TB_MEDICOS`
--
ALTER TABLE `TB_MEDICOS`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `TB_PACIENTES`
--
ALTER TABLE `TB_PACIENTES`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `TB_USUARIOS`
--
ALTER TABLE `TB_USUARIOS`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `TB_AGENDAMENTOS`
--
ALTER TABLE `TB_AGENDAMENTOS`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `TB_CONTATOS`
--
ALTER TABLE `TB_CONTATOS`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `TB_MEDICOS`
--
ALTER TABLE `TB_MEDICOS`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `TB_PACIENTES`
--
ALTER TABLE `TB_PACIENTES`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `TB_USUARIOS`
--
ALTER TABLE `TB_USUARIOS`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;
