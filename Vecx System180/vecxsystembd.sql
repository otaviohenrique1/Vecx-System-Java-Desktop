-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 20-Maio-2017 às 22:29
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vecxsystembd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acessologtb`
--

CREATE TABLE `acessologtb` (
  `codigoregistro_log` varchar(50) DEFAULT NULL,
  `nomefuncionario_log` varchar(100) DEFAULT NULL,
  `cargo_log` varchar(15) DEFAULT NULL,
  `codigofuncionario_log` varchar(50) DEFAULT NULL,
  `login_log` varchar(50) DEFAULT NULL,
  `senha_log` varchar(50) DEFAULT NULL,
  `dataacesso_log` date DEFAULT NULL,
  `horaacesso_log` time DEFAULT NULL,
  `acessolog_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `acessologtb`
--

INSERT INTO `acessologtb` (`codigoregistro_log`, `nomefuncionario_log`, `cargo_log`, `codigofuncionario_log`, `login_log`, `senha_log`, `dataacesso_log`, `horaacesso_log`, `acessolog_id`) VALUES
('2678392862', 'Funcionario 1', 'Gerente', '0558228497', 'funcionario1', 'funcionario1', '2017-05-16', '18:24:00', 1),
('0119745584', 'Funcionario 1', 'Gerente', '0558228497', 'funcionario1', 'funcionario1', '2017-05-16', '20:03:00', 2),
('4544823340', 'Funcionario 1', 'Gerente', '0558228497', 'funcionario1', 'funcionario1', '2017-05-16', '22:46:00', 3),
('3921225361', 'Funcionario 1', 'Gerente', '0558228497', 'funcionario1', 'funcionario1', '2017-05-16', '22:59:00', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientetb`
--

CREATE TABLE `clientetb` (
  `nome_cli` varchar(100) DEFAULT NULL,
  `codigocliente_cli` varchar(50) DEFAULT NULL,
  `rg_cli` varchar(20) DEFAULT NULL,
  `cpf_cli` varchar(20) DEFAULT NULL,
  `datanascimento_cli` date DEFAULT NULL,
  `sexo_cli` varchar(20) DEFAULT NULL,
  `estadocivil_cli` varchar(15) DEFAULT NULL,
  `telefone1_cli` varchar(20) DEFAULT NULL,
  `telefone2_cli` varchar(20) DEFAULT NULL,
  `celular1_cli` varchar(20) DEFAULT NULL,
  `celular2_cli` varchar(20) DEFAULT NULL,
  `email1_cli` varchar(100) DEFAULT NULL,
  `email2_cli` varchar(100) DEFAULT NULL,
  `nacionalidade_cli` varchar(20) DEFAULT NULL,
  `pais_cli` varchar(20) DEFAULT NULL,
  `estado_cli` varchar(100) DEFAULT NULL,
  `cep_cli` varchar(15) DEFAULT NULL,
  `cidade_cli` varchar(100) DEFAULT NULL,
  `endereco_cli` varchar(100) DEFAULT NULL,
  `numero_cli` varchar(20) DEFAULT NULL,
  `complemento_cli` varchar(100) DEFAULT NULL,
  `bairro_cli` varchar(100) DEFAULT NULL,
  `referencia_cli` varchar(100) DEFAULT NULL,
  `funcionarionome_cli` varchar(100) DEFAULT NULL,
  `codigofuncionario_cli` varchar(50) DEFAULT NULL,
  `cargofuncionario_cli` varchar(20) DEFAULT NULL,
  `datacadastro_cli` date DEFAULT NULL,
  `horacadastro_cli` time DEFAULT NULL,
  `cliente_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientetb`
--

INSERT INTO `clientetb` (`nome_cli`, `codigocliente_cli`, `rg_cli`, `cpf_cli`, `datanascimento_cli`, `sexo_cli`, `estadocivil_cli`, `telefone1_cli`, `telefone2_cli`, `celular1_cli`, `celular2_cli`, `email1_cli`, `email2_cli`, `nacionalidade_cli`, `pais_cli`, `estado_cli`, `cep_cli`, `cidade_cli`, `endereco_cli`, `numero_cli`, `complemento_cli`, `bairro_cli`, `referencia_cli`, `funcionarionome_cli`, `codigofuncionario_cli`, `cargofuncionario_cli`, `datacadastro_cli`, `horacadastro_cli`, `cliente_id`) VALUES
('Cliente 1', '2210762392', '84.553.058-0', '850.045.405-2', '1980-03-25', 'Feminino', 'Casado', '(12)9898-9898', '(12)9846-5587', '(12)99988-9988', '(12)99855-5444', 'cliente1@email.com', 'cliente1email@email.com', 'Brasileiro', 'Brasil', 'São Paulo (SP)', '78651-243', 'Cidade do Cliente 1', 'Endereço do Cliente 1', '967', 'Casa', 'Bairro do Cliente 1', 'Referencia da casa do Cliente 1', 'Funcionario 1', '0558228497', 'Gerente', '2017-05-16', '18:37:00', 1),
('Cliente 2', '2704378931', '98.754.632-1', '321.465.987-7', '1976-09-15', 'Feminino', 'Casado', '(12)3198-9665', '(12)3168-9999', '(12)88899-8888', '(12)88775-5444', 'cliente2@email.com', 'cliente2email@email.com', 'Brasileiro', 'Brasil', 'São Paulo (SP)', '65487-921', 'Cidade do Cliente 2', 'Endereço do Cliente 2', '542', 'Casa', 'Bairro do Cliente 2', 'Referencia da casa do Cliente 2', 'Funcionario 1', '0558228497', 'Gerente', '2017-05-16', '18:40:00', 2),
('Cliente 3', '0964644997', '89.774.455-6', '333.558.877-7', '1982-03-19', 'Feminino', 'Casado', '(12)8954-5465', '(12)3265-3265', '(12)99911-8888', '(12)88112-2222', 'cliente3@email.com', 'cliente3email@email.com', 'Brasileiro', 'Brasil', 'São Paulo (SP)', '87455-454', 'Cidade do Cliente 3', 'Endereço do Cliente 3', '953', 'Casa', 'Bairro do Cliente 3', 'Referencia da casa do Cliente 3', 'Funcionario 1', '0558228497', 'Gerente', '2017-05-16', '18:48:00', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `compralistaprodutotb`
--

CREATE TABLE `compralistaprodutotb` (
  `codigoproduto_lis_com` varchar(50) DEFAULT NULL,
  `produto_lis_com` varchar(100) DEFAULT NULL,
  `quantidade_lis_com` double DEFAULT NULL,
  `precounitario_lis_com` double DEFAULT NULL,
  `precoquantidade_lis_com` double DEFAULT NULL,
  `nomefornecedor_lis_com` varchar(50) DEFAULT NULL,
  `codigocompra_lis_com` varchar(50) DEFAULT NULL,
  `datacompra_lis_com` date DEFAULT NULL,
  `horacompra_lis_com` time DEFAULT NULL,
  `compralistaproduto_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `compralistaprodutotb`
--

INSERT INTO `compralistaprodutotb` (`codigoproduto_lis_com`, `produto_lis_com`, `quantidade_lis_com`, `precounitario_lis_com`, `precoquantidade_lis_com`, `nomefornecedor_lis_com`, `codigocompra_lis_com`, `datacompra_lis_com`, `horacompra_lis_com`, `compralistaproduto_id`) VALUES
('9359551194', 'Nome1', 3, 20, 60, 'Fornecedor 1', '9274342377', '2017-01-20', '16:00:00', 1),
('0114618403', 'Nome2', 3, 20, 60, 'Fornecedor 2', '9274342377', '2017-01-20', '16:00:00', 2),
('7001296852', 'Nome3', 3, 20, 60, 'Fornecedor 3', '9274342377', '2017-01-20', '16:00:00', 3),
('7001296852', 'Nome3', 1, 20, 20, 'Fornecedor 3', '1673357565', '2016-10-30', '16:00:00', 21),
('0114618403', 'Nome2', 1, 20, 20, 'Fornecedor 2', '1673357565', '2016-10-30', '16:00:00', 20),
('9359551194', 'Nome1', 1, 20, 20, 'Fornecedor 1', '1673357565', '2016-10-30', '16:00:00', 19);

-- --------------------------------------------------------

--
-- Estrutura da tabela `compratb`
--

CREATE TABLE `compratb` (
  `codigocompra_com` varchar(50) DEFAULT NULL,
  `nomefuncionario_com` varchar(100) DEFAULT NULL,
  `cargofuncionario_com` varchar(20) DEFAULT NULL,
  `codigofuncionario_com` varchar(50) DEFAULT NULL,
  `tipopagamento_com` varchar(50) DEFAULT NULL,
  `metodopagamento_com` varchar(50) DEFAULT NULL,
  `notafiscal_com` varchar(20) DEFAULT NULL,
  `datacompra_com` date DEFAULT NULL,
  `horacompra_com` time DEFAULT NULL,
  `valortotal_com` double DEFAULT NULL,
  `descontoporcentagem_com` double DEFAULT NULL,
  `valortotaldesconto_com` double DEFAULT NULL,
  `quantidadeparcelas_com` int(10) DEFAULT NULL,
  `valortotalparcelado_com` double DEFAULT NULL,
  `compra_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `compratb`
--

INSERT INTO `compratb` (`codigocompra_com`, `nomefuncionario_com`, `cargofuncionario_com`, `codigofuncionario_com`, `tipopagamento_com`, `metodopagamento_com`, `notafiscal_com`, `datacompra_com`, `horacompra_com`, `valortotal_com`, `descontoporcentagem_com`, `valortotaldesconto_com`, `quantidadeparcelas_com`, `valortotalparcelado_com`, `compra_id`) VALUES
('9274342377', 'Funcionario 1', 'Gerente', '0558228497', 'Cartão de credito', 'À vista', 'Pedido', '2017-01-20', '16:00:00', 180, 30, 126, 0, 0, 1),
('1673357565', 'Nome', 'Cargo', 'Codigo', 'Cartão de credito', 'À vista', 'Pedido', '2016-10-30', '16:00:00', 60, 10, 54, 0, 0, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `controleferiastb`
--

CREATE TABLE `controleferiastb` (
  `funcionario_ferias` varchar(100) DEFAULT NULL,
  `codigofuncionario_ferias` varchar(50) DEFAULT NULL,
  `cargo_ferias` varchar(20) DEFAULT NULL,
  `tipoferiasfolga_ferias` varchar(20) DEFAULT NULL,
  `feriasduracao_ferias` varchar(15) DEFAULT NULL,
  `feriasinicio_ferias` date DEFAULT NULL,
  `feriasfinal_ferias` date DEFAULT NULL,
  `totalferias_ferias` int(10) DEFAULT NULL,
  `totalfolgas_ferias` int(10) DEFAULT NULL,
  `datacadastro_ferias` date DEFAULT NULL,
  `horacadastro_ferias` time DEFAULT NULL,
  `responsavelcadastro_ferias` varchar(100) DEFAULT NULL,
  `cargoresponsavel_ferias` varchar(20) DEFAULT NULL,
  `codigoresponsavel_ferias` varchar(50) DEFAULT NULL,
  `controleferias_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `controleferiastb`
--

INSERT INTO `controleferiastb` (`funcionario_ferias`, `codigofuncionario_ferias`, `cargo_ferias`, `tipoferiasfolga_ferias`, `feriasduracao_ferias`, `feriasinicio_ferias`, `feriasfinal_ferias`, `totalferias_ferias`, `totalfolgas_ferias`, `datacadastro_ferias`, `horacadastro_ferias`, `responsavelcadastro_ferias`, `cargoresponsavel_ferias`, `codigoresponsavel_ferias`, `controleferias_id`) VALUES
('Funcionario 2', '8036729306', 'Atendente', 'Ferias', '30 dia(s)', '2016-09-16', '2016-10-16', 1, 0, '2017-05-16', '20:19:00', 'Funcionario 2', 'Atendente', '8036729306', 1),
('Funcionario 2', '8036729306', 'Atendente', 'Folga', '1 dia(s)', '2016-10-20', '2016-10-21', 0, 1, '2017-05-16', '20:21:00', 'Funcionario 2', 'Atendente', '8036729306', 2),
('Funcionario 2', '8036729306', 'Atendente', 'Ferias', '30 dia(s)', '2016-03-10', '2016-04-10', 1, 0, '2017-05-16', '20:33:00', 'Funcionario 2', 'Atendente', '8036729306', 3),
('Funcionario 2', '8036729306', 'Atendente', 'Ferias', '30 mes(es)', '2016-08-10', '2016-09-10', 1, 0, '2017-05-16', '21:09:00', 'Funcionario 2', 'Atendente', '8036729306', 4),
('Funcionario 2', '8036729306', 'Atendente', 'Ferias', '30 mes(es)', '2016-11-21', '2016-12-21', 1, 0, '2017-05-16', '21:19:00', 'Funcionario 2', 'Atendente', '8036729306', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `dadoslojatb`
--

CREATE TABLE `dadoslojatb` (
  `nomeloja_dados` varchar(100) DEFAULT NULL,
  `razaosocial_dados` varchar(100) DEFAULT NULL,
  `cnpj_dados` varchar(20) DEFAULT NULL,
  `cpf_dados` varchar(20) DEFAULT NULL,
  `inscricaoestadual_dados` varchar(50) DEFAULT NULL,
  `inscricaonumero_dados` varchar(50) DEFAULT NULL,
  `telefone1_dados` varchar(20) DEFAULT NULL,
  `telefone2_dados` varchar(20) DEFAULT NULL,
  `celular1_dados` varchar(20) DEFAULT NULL,
  `celular2_dados` varchar(20) DEFAULT NULL,
  `email1_dados` varchar(100) DEFAULT NULL,
  `email2_dados` varchar(100) DEFAULT NULL,
  `estado_dados` varchar(50) DEFAULT NULL,
  `cep_dados` varchar(20) DEFAULT NULL,
  `cidade_dados` varchar(100) DEFAULT NULL,
  `endereco_dados` varchar(50) DEFAULT NULL,
  `numero_dados` varchar(20) DEFAULT NULL,
  `complemento_dados` varchar(20) DEFAULT NULL,
  `bairro_dados` varchar(50) DEFAULT NULL,
  `referencia_dados` varchar(100) DEFAULT NULL,
  `pais_dados` varchar(50) DEFAULT NULL,
  `nacionalidade_dados` varchar(20) DEFAULT NULL,
  `datacadastro_dados` date DEFAULT NULL,
  `horacadastro_dados` time DEFAULT NULL,
  `estadodadosloja_dados` varchar(20) DEFAULT NULL,
  `lojadados_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `dadoslojatb`
--

INSERT INTO `dadoslojatb` (`nomeloja_dados`, `razaosocial_dados`, `cnpj_dados`, `cpf_dados`, `inscricaoestadual_dados`, `inscricaonumero_dados`, `telefone1_dados`, `telefone2_dados`, `celular1_dados`, `celular2_dados`, `email1_dados`, `email2_dados`, `estado_dados`, `cep_dados`, `cidade_dados`, `endereco_dados`, `numero_dados`, `complemento_dados`, `bairro_dados`, `referencia_dados`, `pais_dados`, `nacionalidade_dados`, `datacadastro_dados`, `horacadastro_dados`, `estadodadosloja_dados`, `lojadados_id`) VALUES
('Nome loja', 'Razao', '45.848.545/5646-5', '454.654.646-5', 'Isento', '546545645', '(12)5241-6545', '(10)2545-6465', '(20)24546-5564', '(45)64654-5645', 'email1@email.com', 'email2@email.com', 'Pará (PA)', '25561-524', 'Cidade', 'Endereco', '1232', 'Loja', 'Bairro', 'Referencia', 'pais', 'Nacionalidade', '2017-05-14', '18:21:00', 'Ativo', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `descontotb`
--

CREATE TABLE `descontotb` (
  `codigodesconto_des` varchar(50) DEFAULT NULL,
  `estadodesconto_des` varchar(50) DEFAULT NULL,
  `codigoproduto_des` varchar(50) DEFAULT NULL,
  `nomeproduto_des` varchar(100) DEFAULT NULL,
  `preconormal_des` double DEFAULT NULL,
  `desconto_des` double DEFAULT NULL,
  `precodesconto_des` double DEFAULT NULL,
  `datainicio_des` date DEFAULT NULL,
  `horainicio_des` time DEFAULT NULL,
  `datatermino_des` date DEFAULT NULL,
  `horatermino_des` time DEFAULT NULL,
  `datacadastro_des` date DEFAULT NULL,
  `horacadastro_des` time DEFAULT NULL,
  `nomeresponsavel_des` varchar(100) DEFAULT NULL,
  `cargoresponsavel_des` varchar(50) DEFAULT NULL,
  `codigoresponsavel_des` varchar(50) DEFAULT NULL,
  `funcionariocadastro_des` varchar(100) DEFAULT NULL,
  `codigofuncionario_des` varchar(50) DEFAULT NULL,
  `cargofuncionario_des` varchar(20) DEFAULT NULL,
  `desconto_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoqueprodutotb`
--

CREATE TABLE `estoqueprodutotb` (
  `codigoproduto_est` varchar(50) DEFAULT NULL,
  `produto_est` varchar(100) DEFAULT NULL,
  `quantidade_est` double DEFAULT NULL,
  `quantidadeunidade_est` varchar(20) DEFAULT NULL,
  `lote_est` varchar(50) DEFAULT NULL,
  `preco_est` double DEFAULT NULL,
  `estadoproduto_est` varchar(20) DEFAULT NULL,
  `estoqueproduto_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estoqueprodutotb`
--

INSERT INTO `estoqueprodutotb` (`codigoproduto_est`, `produto_est`, `quantidade_est`, `quantidadeunidade_est`, `lote_est`, `preco_est`, `estadoproduto_est`, `estoqueproduto_id`) VALUES
('9359551194', 'Nome1', 101, 'unidade(s)', 'Lote123', 20, 'Em estoque', 1),
('0114618403', 'Nome2', 101, 'unidade(s)', 'Lote321', 20, 'Em estoque', 2),
('7001296852', 'Nome3', 101, 'unidade(s)', 'Lote132', 20, 'Em estoque', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedortb`
--

CREATE TABLE `fornecedortb` (
  `nome_for` varchar(100) DEFAULT NULL,
  `razaosocial_for` varchar(100) DEFAULT NULL,
  `codigofornecedor_for` varchar(50) DEFAULT NULL,
  `cnpj_for` varchar(20) DEFAULT NULL,
  `cpf_for` varchar(20) DEFAULT NULL,
  `inscricaoestadual_for` varchar(20) DEFAULT NULL,
  `inscricaonumero_for` varchar(50) DEFAULT NULL,
  `telefone1_for` varchar(20) DEFAULT NULL,
  `telefone2_for` varchar(20) DEFAULT NULL,
  `celular1_for` varchar(20) DEFAULT NULL,
  `celular2_for` varchar(20) DEFAULT NULL,
  `email1_for` varchar(100) DEFAULT NULL,
  `email2_for` varchar(100) DEFAULT NULL,
  `cep_for` varchar(15) DEFAULT NULL,
  `endereco_for` varchar(100) DEFAULT NULL,
  `numero_for` varchar(20) DEFAULT NULL,
  `complemento_for` varchar(100) DEFAULT NULL,
  `bairro_for` varchar(100) DEFAULT NULL,
  `estado_for` varchar(20) DEFAULT NULL,
  `cidade_for` varchar(100) DEFAULT NULL,
  `referencia_for` varchar(100) DEFAULT NULL,
  `nacionalidade_for` varchar(15) DEFAULT NULL,
  `pais_for` varchar(30) DEFAULT NULL,
  `tipocomercio_for` varchar(20) DEFAULT NULL,
  `tipofornecedor_for` varchar(30) DEFAULT NULL,
  `datacadastro_for` date DEFAULT NULL,
  `horacadastro_for` time DEFAULT NULL,
  `funcionarionome_for` varchar(100) DEFAULT NULL,
  `codigofuncionario_for` varchar(50) DEFAULT NULL,
  `cargofuncionario_for` varchar(20) DEFAULT NULL,
  `fornecedor_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedortb`
--

INSERT INTO `fornecedortb` (`nome_for`, `razaosocial_for`, `codigofornecedor_for`, `cnpj_for`, `cpf_for`, `inscricaoestadual_for`, `inscricaonumero_for`, `telefone1_for`, `telefone2_for`, `celular1_for`, `celular2_for`, `email1_for`, `email2_for`, `cep_for`, `endereco_for`, `numero_for`, `complemento_for`, `bairro_for`, `estado_for`, `cidade_for`, `referencia_for`, `nacionalidade_for`, `pais_for`, `tipocomercio_for`, `tipofornecedor_for`, `datacadastro_for`, `horacadastro_for`, `funcionarionome_for`, `codigofuncionario_for`, `cargofuncionario_for`, `fornecedor_id`) VALUES
('Fornecedor 1', 'Fornecedor 1 Razão Social', '3275626205', '12.312.321/3213-2', '813.827.298-2', 'Isento', '986545455', '(12)3198-6955', '(12)3198-7799', '(12)88888-9999', '(12)36633-3222', 'fornecedor1@email.com', 'fornecedor2email@email.com', '85446-454', 'Endereço do Fornecedor 1', '623', 'Loja', 'Bairro do Fornecedor 1', 'São Paulo (SP)', 'Cidade do Fornecedor 1', 'Referencia do estabelecimento do Fornecedor 1', 'Brasileiro', 'Brasil', 'Varejo', 'Fornecedor', '2017-05-16', '18:53:00', 'Funcionario 1', '0558228497', 'Gerente', 1),
('Fornecedor 2', 'Fornecedor 2 Razão Social', '6952925090', '12.312.321/3213-5', '786.322.222-2', 'Isento', '54646456477', '(12)5554-5981', '(12)3888-8890', '(12)97887-7777', '(12)36633-3222', 'fornecedor2@email.com', 'fornecedor2@email.com', '28824-684', 'Endereço do Fornecedor 2', '782', 'Loja', 'Bairro do Fornecedor 2', 'São Paulo (SP)', 'Cidade do Fornecedor 2', 'Referencia do estabelecimento do Fornecedor 2', 'Brasileiro', 'Brasil', 'Atacado', 'Fornecedor', '2017-05-16', '19:04:00', 'Funcionario 1', '0558228497', 'Gerente', 2),
('Fornecedor 3', 'Fornecedor 3 Razão Social', '2993738456', '12.312.321/3213-9', '885.511.111-2', 'Isento', '98946545522', '(12)3198-7777', '(12)3288-7774', '(12)88889-9955', '(12)88812-1119', 'fornecedor3@email.com', 'fornecedor3email@email.com', '87545-455', 'Endereço do Fornecedor 3', '394', 'Loja', 'Bairro do Fornecedor 3', 'São Paulo (SP)', 'Cidade do Fornecedor 3', 'Referencia do estabelecimento do Fornecedor 3', 'Brasileiro', 'Brasil', 'Atacado', 'Fornecedor', '2017-05-16', '19:07:00', 'Funcionario 1', '0558228497', 'Gerente', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionariohistoricolistafaltastb`
--

CREATE TABLE `funcionariohistoricolistafaltastb` (
  `codigofuncionario_his_lis` varchar(50) DEFAULT NULL,
  `funcionario_his_lis` varchar(100) DEFAULT NULL,
  `cargofuncionario_his_lis` varchar(20) DEFAULT NULL,
  `datatrabalho_his_lis` date DEFAULT NULL,
  `frequencia_his_lis` varchar(20) DEFAULT NULL,
  `horacadastro_his_lis` time DEFAULT NULL,
  `historicolistafalta_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionariohistoricolistafaltastb`
--

INSERT INTO `funcionariohistoricolistafaltastb` (`codigofuncionario_his_lis`, `funcionario_his_lis`, `cargofuncionario_his_lis`, `datatrabalho_his_lis`, `frequencia_his_lis`, `horacadastro_his_lis`, `historicolistafalta_id`) VALUES
('7942923175', 'Funcionario 4', 'Atendente', '2017-05-16', 'Falta', '20:17:00', 1),
('7942923175', 'Funcionario 4', 'Atendente', '2017-05-16', 'Falta', '20:17:00', 2),
('7942923175', 'Funcionario 4', 'Atendente', '2017-05-16', 'Falta', '20:18:00', 3),
('7942923175', 'Funcionario 4', 'Atendente', '2017-05-16', 'Falta', '20:18:00', 4),
('7942923175', 'Funcionario 4', 'Atendente', '2017-05-16', 'Falta', '20:18:00', 5),
('8036729306', 'Funcionario 2', 'Atendente', '2017-05-16', 'Falta', '20:18:00', 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionariohistoricotb`
--

CREATE TABLE `funcionariohistoricotb` (
  `codigofuncionario_his` varchar(50) DEFAULT NULL,
  `funcionario_his` varchar(100) DEFAULT NULL,
  `cargofuncionario_his` varchar(20) DEFAULT NULL,
  `entradafuncionario_his` time DEFAULT NULL,
  `saidafuncionario_his` time DEFAULT NULL,
  `presencaquantidade_his` int(10) DEFAULT NULL,
  `faltaquantidade_his` int(10) DEFAULT NULL,
  `maximofalta_his` int(10) DEFAULT NULL,
  `cargahoraria_his` varchar(20) DEFAULT NULL,
  `cargahorariaunidade_his` varchar(15) DEFAULT NULL,
  `funcionariohistorico_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionariohistoricotb`
--

INSERT INTO `funcionariohistoricotb` (`codigofuncionario_his`, `funcionario_his`, `cargofuncionario_his`, `entradafuncionario_his`, `saidafuncionario_his`, `presencaquantidade_his`, `faltaquantidade_his`, `maximofalta_his`, `cargahoraria_his`, `cargahorariaunidade_his`, `funcionariohistorico_id`) VALUES
('0558228497', 'Funcionario 1', 'Gerente', '10:00:00', '18:00:00', 0, 0, 10, '8', 'hora(s)', 1),
('8036729306', 'Funcionario 2', 'Atendente', '10:00:00', '18:00:00', 2, 1, 10, '8', 'hora(s)', 2),
('1485704080', 'Funcionario 3', 'Carregador', '10:00:00', '18:00:00', 0, 0, 10, '8', 'hora(s)', 3),
('7942923175', 'Funcionario 4', 'Atendente', '10:00:00', '18:00:00', 2, 5, 10, '8', 'hora(s)', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionariosalariotb`
--

CREATE TABLE `funcionariosalariotb` (
  `estadocomissaobonus_sal` varchar(20) DEFAULT NULL,
  `codigofuncionario_sal` varchar(50) DEFAULT NULL,
  `funcionario_sal` varchar(100) DEFAULT NULL,
  `cargo_sal` varchar(20) DEFAULT NULL,
  `salariofuncionario_sal` double DEFAULT NULL,
  `valorbonus_sal` double DEFAULT NULL,
  `valorcomissao_sal` double DEFAULT NULL,
  `datacadastro_sal` date DEFAULT NULL,
  `horacadastro_sal` time DEFAULT NULL,
  `funcionarioresponsavel_sal` varchar(100) DEFAULT NULL,
  `cargoresponsavel_sal` varchar(20) DEFAULT NULL,
  `codigoresponsavel_sal` varchar(50) DEFAULT NULL,
  `funcionariosalario_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionariosalariotb`
--

INSERT INTO `funcionariosalariotb` (`estadocomissaobonus_sal`, `codigofuncionario_sal`, `funcionario_sal`, `cargo_sal`, `salariofuncionario_sal`, `valorbonus_sal`, `valorcomissao_sal`, `datacadastro_sal`, `horacadastro_sal`, `funcionarioresponsavel_sal`, `cargoresponsavel_sal`, `codigoresponsavel_sal`, `funcionariosalario_id`) VALUES
('Adição', '8036729306', 'Funcionario 2', 'Atendente', 4010, 0, 10, '2017-05-16', '20:21:00', 'Funcionario 1', 'Gerente', '0558228497', 1),
('Subtração', '8036729306', 'Funcionario 2', 'Atendente', 4000, 0, 10, '2017-05-16', '20:21:00', 'Funcionario 1', 'Gerente', '0558228497', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionariotb`
--

CREATE TABLE `funcionariotb` (
  `nome_fun` varchar(100) DEFAULT NULL,
  `codigofuncionario_fun` varchar(50) DEFAULT NULL,
  `rg_fun` varchar(20) DEFAULT NULL,
  `cpf_fun` varchar(20) DEFAULT NULL,
  `datanascimento_fun` date DEFAULT NULL,
  `sexo_fun` varchar(20) DEFAULT NULL,
  `estadocivil_fun` varchar(20) DEFAULT NULL,
  `telefone1_fun` varchar(20) DEFAULT NULL,
  `telefone2_fun` varchar(20) DEFAULT NULL,
  `celular1_fun` varchar(20) DEFAULT NULL,
  `celular2_fun` varchar(20) DEFAULT NULL,
  `email1_fun` varchar(100) DEFAULT NULL,
  `email2_fun` varchar(100) DEFAULT NULL,
  `escolaridade_fun` varchar(20) DEFAULT NULL,
  `nacionalidade_fun` varchar(30) DEFAULT NULL,
  `pais_fun` varchar(30) DEFAULT NULL,
  `nomemae_fun` varchar(100) DEFAULT NULL,
  `nomepai_fun` varchar(100) DEFAULT NULL,
  `login_fun` varchar(100) DEFAULT NULL,
  `senha_fun` varchar(100) DEFAULT NULL,
  `cargo_fun` varchar(20) DEFAULT NULL,
  `carteiratrabalho_fun` varchar(30) DEFAULT NULL,
  `salario_fun` double DEFAULT NULL,
  `formapagamento_fun` varchar(20) DEFAULT NULL,
  `nomebanco_fun` varchar(30) DEFAULT NULL,
  `tipotrabalho_fun` varchar(50) DEFAULT NULL,
  `dataadmissao_fun` date DEFAULT NULL,
  `datademissao_fun` date DEFAULT NULL,
  `horarioentrada_fun` time DEFAULT NULL,
  `horariosaida_fun` time DEFAULT NULL,
  `cargahoraria_fun` varchar(20) DEFAULT NULL,
  `cargahorariaunidade_fun` varchar(20) DEFAULT NULL,
  `maximofalta_fun` int(10) DEFAULT NULL,
  `estado_fun` varchar(20) DEFAULT NULL,
  `cep_fun` varchar(15) DEFAULT NULL,
  `cidade_fun` varchar(100) DEFAULT NULL,
  `endereco_fun` varchar(100) DEFAULT NULL,
  `numero_fun` varchar(20) DEFAULT NULL,
  `complemento_fun` varchar(30) DEFAULT NULL,
  `bairro_fun` varchar(100) DEFAULT NULL,
  `referencia_fun` varchar(100) DEFAULT NULL,
  `datacadastro_fun` date DEFAULT NULL,
  `horacadastro_fun` time DEFAULT NULL,
  `funcionario_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionariotb`
--

INSERT INTO `funcionariotb` (`nome_fun`, `codigofuncionario_fun`, `rg_fun`, `cpf_fun`, `datanascimento_fun`, `sexo_fun`, `estadocivil_fun`, `telefone1_fun`, `telefone2_fun`, `celular1_fun`, `celular2_fun`, `email1_fun`, `email2_fun`, `escolaridade_fun`, `nacionalidade_fun`, `pais_fun`, `nomemae_fun`, `nomepai_fun`, `login_fun`, `senha_fun`, `cargo_fun`, `carteiratrabalho_fun`, `salario_fun`, `formapagamento_fun`, `nomebanco_fun`, `tipotrabalho_fun`, `dataadmissao_fun`, `datademissao_fun`, `horarioentrada_fun`, `horariosaida_fun`, `cargahoraria_fun`, `cargahorariaunidade_fun`, `maximofalta_fun`, `estado_fun`, `cep_fun`, `cidade_fun`, `endereco_fun`, `numero_fun`, `complemento_fun`, `bairro_fun`, `referencia_fun`, `datacadastro_fun`, `horacadastro_fun`, `funcionario_id`) VALUES
('Funcionario 1', '0558228497', '98.655.454-8', '985.212.235-4', '1980-10-02', 'Masculino', 'Casado', '(12)3221-3123', '(12)3221-3554', '(12)97999-7977', '(12)95545-8444', 'funcionario1@email.com', 'funcionario2@email.com', 'Superior', 'Brasileira', 'Brasil', 'Mãe do Funcionario 1', 'Pai do Funcionario 1', 'funcionario1', 'funcionario1', 'Gerente', '786532', 6000, 'Mensal', 'Banco 1', 'Fixo', '2000-12-10', NULL, '10:00:00', '18:00:00', '8', 'hora(s)', 10, 'São Paulo (SP)', '87986-565', 'Cidade 1', 'Endereço do Funcionario 1', '1254', 'Casa', 'Bairro do Funcionario 1', 'Referencia da casa do Funcionario 1', '2017-05-16', '17:24:00', 1),
('Funcionario 2', '8036729306', '55.465.454-5', '654.888.922-2', '1978-01-30', 'Masculino', 'Casado', '(12)3395-5654', '(12)3354-5646', '(12)88988-8888', '(12)88987-7744', 'funcionario2@email.com', 'funcionario2email@email.com', 'Superior', 'Brasileiro', 'Brasil', 'Mãe do Funcionario 2', 'Pai do Funcionario 2', 'funcionario2', 'funcionario2', 'Atendente', '324152', 4000, 'Mensal', 'Banco 1', 'Fixo', '2001-07-23', NULL, '10:00:00', '18:00:00', '8', 'hora(s)', 10, 'São Paulo (SP)', '98636-224', 'Cidade do Funcionario 2 ', 'Endereço do Funcionario 2', '652', 'Casa', 'Bairro do Funcionario 2', 'Referencia da casa do Funcionario 2', '2017-05-16', '17:54:00', 2),
('Funcionario 3', '1485704080', '69.595.748-2', '379.146.286-5', '1978-11-20', 'Masculino', 'Solteiro', '(12)3354-5654', '(12)3384-5427', '(12)89877-2111', '(12)88822-2444', 'funcionario3@email.com', 'funcionario3email@email.com', 'Superior', 'Brasileiro', 'Brasil', 'Mae do Funcionario 3', 'Pai do Funcionario 3', 'funcionario3', 'funcionario3', 'Carregador', '468219', 3000, 'Mensal', 'Banco 1', 'Fixo', '2002-08-14', NULL, '10:00:00', '18:00:00', '8', 'hora(s)', 10, 'São Paulo (SP)', '54656-422', 'Cidade do Funcionario 3', 'Endereço do Funcionario 3', '862', 'Casa', 'Bairro do Funcionario 3', 'Referencia da casa do Funcionario 3 ', '2017-05-16', '18:04:00', 3),
('Funcionario 4', '7942923175', '74.884.484-4', '211.564.941-4', '1981-01-30', 'Masculino', 'Casado', '(12)3154-5688', '(12)3164-5644', '(12)99888-8555', '(12)89859-2777', 'funcionario4@email.com', 'funcionario4email@email.com', 'Superior', 'Brasileiro', 'Brasil', 'Mãe do Funcionario 4', 'Pai do Funcionario 4', 'funcionario4', 'funcionario4', 'Atendente', '123698', 4000, 'Mensal', 'Banco 1', 'Fixo', '2000-05-16', '2003-06-16', '10:00:00', '18:00:00', '8', 'hora(s)', 10, 'São Paulo (SP)', '58296-787', 'Cidade do Funcionario 4', 'Endereço do Funcionario 4', '375', 'Casa', 'Bairro do Funcionario 4', 'Referencia da casa do Funcionario 4', '2017-05-16', '18:09:00', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `historicoreposicaoestoquetb`
--

CREATE TABLE `historicoreposicaoestoquetb` (
  `codigocompra_hist_rep` varchar(50) DEFAULT NULL,
  `funcionario_hist_rep` varchar(100) DEFAULT NULL,
  `datacompra_hist_rep` date DEFAULT NULL,
  `horacompra_hist_rep` time DEFAULT NULL,
  `precototal_hist_rep` double DEFAULT NULL,
  `historicoreposicaoestoque_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `historicoreposicaoestoquetb`
--

INSERT INTO `historicoreposicaoestoquetb` (`codigocompra_hist_rep`, `funcionario_hist_rep`, `datacompra_hist_rep`, `horacompra_hist_rep`, `precototal_hist_rep`, `historicoreposicaoestoque_id`) VALUES
('9274342377', 'Funcionario 1', '2017-01-20', '16:00:00', 180, 1),
('1673357565', 'Nome', '2016-10-30', '16:00:00', 60, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `historicovendatb`
--

CREATE TABLE `historicovendatb` (
  `codigovenda_hist_ven` varchar(50) DEFAULT NULL,
  `cliente_hist_ven` varchar(100) DEFAULT NULL,
  `funcionario_hist_ven` varchar(100) DEFAULT NULL,
  `datavenda_hist_ven` date DEFAULT NULL,
  `horavenda_hist_ven` time DEFAULT NULL,
  `precototal_hist_ven` double DEFAULT NULL,
  `historicovenda_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `historicovendatb`
--

INSERT INTO `historicovendatb` (`codigovenda_hist_ven`, `cliente_hist_ven`, `funcionario_hist_ven`, `datavenda_hist_ven`, `horavenda_hist_ven`, `precototal_hist_ven`, `historicovenda_id`) VALUES
('8313551608', 'Cliente 1', 'Nome', '2016-10-12', '14:00:00', 60, 1),
('3540814914', 'Cliente 2', 'Nome', '2016-02-14', '15:00:00', 60, 2),
('6157962886', 'Cliente 1', 'Funcionario 1', '2016-07-12', '15:00:00', 60, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `notafiscaltb`
--

CREATE TABLE `notafiscaltb` (
  `codigonota_nota` varchar(50) DEFAULT NULL,
  `codigovenda_nota` varchar(50) DEFAULT NULL,
  `dataemissao_nota` datetime DEFAULT NULL,
  `horaemissao_nota` time DEFAULT NULL,
  `tipopagamento_nota` varchar(30) DEFAULT NULL,
  `metodopagamento_nota` varchar(30) DEFAULT NULL,
  `notafiscalpaulista_nota` varchar(20) DEFAULT NULL,
  `nomecliente_nota` varchar(100) DEFAULT NULL,
  `cpfcliente_nota` varchar(50) DEFAULT NULL,
  `codigocliente_nota` varchar(50) DEFAULT NULL,
  `telefonecliente_nota` varchar(20) DEFAULT NULL,
  `celularcliente_nota` varchar(50) DEFAULT NULL,
  `enderecocliente_nota` varchar(100) DEFAULT NULL,
  `numerocliente_nota` varchar(20) DEFAULT NULL,
  `bairrocliente_nota` varchar(50) DEFAULT NULL,
  `cepcliente_nota` varchar(20) DEFAULT NULL,
  `estadocliente_nota` varchar(50) DEFAULT NULL,
  `cidadecliente_nota` varchar(50) DEFAULT NULL,
  `funcionarionome_nota` varchar(100) DEFAULT NULL,
  `codigofuncionario_nota` varchar(50) DEFAULT NULL,
  `cargofuncionario_nota` varchar(20) DEFAULT NULL,
  `tiponotafiscal_nota` varchar(20) DEFAULT NULL,
  `precototal_nota` double DEFAULT NULL,
  `descontoporcentagem_nota` double DEFAULT NULL,
  `valortotaldesconto_nota` double DEFAULT NULL,
  `quantidadeparcelas_nota` int(10) DEFAULT NULL,
  `valortotalparcelado_nota` double DEFAULT NULL,
  `notafiscal_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `notafiscaltb`
--

INSERT INTO `notafiscaltb` (`codigonota_nota`, `codigovenda_nota`, `dataemissao_nota`, `horaemissao_nota`, `tipopagamento_nota`, `metodopagamento_nota`, `notafiscalpaulista_nota`, `nomecliente_nota`, `cpfcliente_nota`, `codigocliente_nota`, `telefonecliente_nota`, `celularcliente_nota`, `enderecocliente_nota`, `numerocliente_nota`, `bairrocliente_nota`, `cepcliente_nota`, `estadocliente_nota`, `cidadecliente_nota`, `funcionarionome_nota`, `codigofuncionario_nota`, `cargofuncionario_nota`, `tiponotafiscal_nota`, `precototal_nota`, `descontoporcentagem_nota`, `valortotaldesconto_nota`, `quantidadeparcelas_nota`, `valortotalparcelado_nota`, `notafiscal_id`) VALUES
('4489342777', '8313551608', '2016-10-12 00:00:00', '14:00:00', 'Cartão de credito', 'À vista', 'Pedido', 'Cliente 1', '850.045.405-2', '2210762392', '(12)9898-9898', '(12)99988-9988', 'Endereço do Cliente 1', '967', 'Bairro do Cliente 1', '78651-243', 'São Paulo (SP)', 'Cidade do Cliente 1', 'Funcionario 1', '0558228497', 'Gerente', 'Venda', 60, 50, 30, 0, 0, 1),
('4219636329', '3540814914', '2016-02-14 00:00:00', '15:00:00', 'Cartão de credito', 'À vista', 'Pedido', 'Cliente 1', '850.045.405-2', '2210762392', '(12)9898-9898', '(12)99988-9988', 'Endereço do Cliente 1', '967', 'Bairro do Cliente 1', '78651-243', 'São Paulo (SP)', 'Cidade do Cliente 1', 'Funcionario 1', '0558228497', 'Gerente', 'Venda', 60, 50, 30, 0, 0, 2),
('1314344781', '6157962886', '2016-07-12 00:00:00', '15:00:00', 'Cartão de credito', 'À vista', 'Pedido', 'Cliente 1', '850.045.405-2', '2210762392', '(12)9898-9898', '(12)99988-9988', 'Endereço do Cliente 1', '967', 'Bairro do Cliente 1', '78651-243', 'São Paulo (SP)', 'Cidade do Cliente 1', 'Funcionario 1', '0558228497', 'Gerente', 'Venda', 60, 10, 54, 0, 0, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtotb`
--

CREATE TABLE `produtotb` (
  `codigoproduto_pro` varchar(50) DEFAULT NULL,
  `nome_pro` varchar(100) DEFAULT NULL,
  `marca_pro` varchar(100) DEFAULT NULL,
  `lote_pro` varchar(50) DEFAULT NULL,
  `quantidade_pro` double DEFAULT NULL,
  `quantidadeunidade_pro` varchar(30) DEFAULT NULL,
  `codigobarras_pro` varchar(50) DEFAULT NULL,
  `dataprimeiracompra_pro` date DEFAULT NULL,
  `datafabricacao_pro` date DEFAULT NULL,
  `datavalidade_pro` date DEFAULT NULL,
  `vidautil_pro` varchar(30) DEFAULT NULL,
  `vidautilunidade_pro` varchar(30) DEFAULT NULL,
  `precocompra_pro` double DEFAULT NULL,
  `precovendaavista` double DEFAULT NULL,
  `origemproduto_pro` varchar(20) DEFAULT NULL,
  `garantia_pro` varchar(50) DEFAULT NULL,
  `garantiaunidade_pro` varchar(20) DEFAULT NULL,
  `fornecedor_pro` varchar(100) DEFAULT NULL,
  `fornecedorcnpj_pro` varchar(50) DEFAULT NULL,
  `tipoproduto_pro` varchar(50) DEFAULT NULL,
  `quantcomponetes_pro` int(50) DEFAULT NULL,
  `aplicacao_pro` varchar(100) DEFAULT NULL,
  `embalagem_pro` varchar(50) DEFAULT NULL,
  `embalagemtipo_pro` varchar(50) DEFAULT NULL,
  `estampa_pro` varchar(50) DEFAULT NULL,
  `estampatipo_pro` varchar(50) DEFAULT NULL,
  `cor_pro` varchar(50) DEFAULT NULL,
  `modelo_pro` varchar(50) DEFAULT NULL,
  `montagem_pro` varchar(20) DEFAULT NULL,
  `acessorios_pro` text,
  `peso_pro` varchar(30) DEFAULT NULL,
  `pesounidade_pro` varchar(30) DEFAULT NULL,
  `altura_pro` varchar(30) DEFAULT NULL,
  `alturaunidade_pro` varchar(30) DEFAULT NULL,
  `comprimento_pro` varchar(30) DEFAULT NULL,
  `comprimentounidade_pro` varchar(30) DEFAULT NULL,
  `largura_pro` varchar(30) DEFAULT NULL,
  `larguraunidade_pro` varchar(30) DEFAULT NULL,
  `profundidade_pro` varchar(30) DEFAULT NULL,
  `profundidadeunidade_pro` varchar(30) DEFAULT NULL,
  `espessura_pro` varchar(30) DEFAULT NULL,
  `espessuraunidade_pro` varchar(30) DEFAULT NULL,
  `descricao_pro` text,
  `datacadastro_pro` date DEFAULT NULL,
  `horacadastro_pro` time DEFAULT NULL,
  `funcionarionome_pro` varchar(100) DEFAULT NULL,
  `codigofuncionario_pro` varchar(50) DEFAULT NULL,
  `cargofuncionario_pro` varchar(30) DEFAULT NULL,
  `produto_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtotb`
--

INSERT INTO `produtotb` (`codigoproduto_pro`, `nome_pro`, `marca_pro`, `lote_pro`, `quantidade_pro`, `quantidadeunidade_pro`, `codigobarras_pro`, `dataprimeiracompra_pro`, `datafabricacao_pro`, `datavalidade_pro`, `vidautil_pro`, `vidautilunidade_pro`, `precocompra_pro`, `precovendaavista`, `origemproduto_pro`, `garantia_pro`, `garantiaunidade_pro`, `fornecedor_pro`, `fornecedorcnpj_pro`, `tipoproduto_pro`, `quantcomponetes_pro`, `aplicacao_pro`, `embalagem_pro`, `embalagemtipo_pro`, `estampa_pro`, `estampatipo_pro`, `cor_pro`, `modelo_pro`, `montagem_pro`, `acessorios_pro`, `peso_pro`, `pesounidade_pro`, `altura_pro`, `alturaunidade_pro`, `comprimento_pro`, `comprimentounidade_pro`, `largura_pro`, `larguraunidade_pro`, `profundidade_pro`, `profundidadeunidade_pro`, `espessura_pro`, `espessuraunidade_pro`, `descricao_pro`, `datacadastro_pro`, `horacadastro_pro`, `funcionarionome_pro`, `codigofuncionario_pro`, `cargofuncionario_pro`, `produto_id`) VALUES
('9359551194', 'Nome1', 'Marca1', 'Lote123', 101, 'unidade(s)', '12521', '2016-06-12', '2016-01-10', '2018-06-12', '2', 'ano(s)', 10, 20, 'Nacional', '10', 'ano(s)', 'Fornecedor1', '12.312.321/3213-2', 'Tipo de produto 1', 1, 'Aplicacao 1', 'Sim', 'Tipo de embalagem', 'Sim', 'Tipo de estampa', 'Tipo de produto', 'Tipo de produto', 'Sim', 'Descricao', '10', 'kg', '10', 'm', '10', 'm', '10', 'm', '10', 'm', '10', 'm', 'Descricao', '2017-05-15', '20:41:00', 'Funcionario 1', '1254964578', 'Gerente', 1),
('0114618403', 'Nome2', 'Marca2', 'Lote321', 101, 'unidade(s)', '12522', '2016-06-14', '2016-01-10', '2018-06-14', '2', 'ano(s)', 10, 20, 'Nacional', '10', 'ano(s)', 'Fornecedor2', '12.312.321/3213-5', 'Tipo de produto 2', 1, 'Aplicacao 2', 'Sim', 'Tipo de embalagem', 'Sim', 'Tipo de estampa', 'Produto sem informações', 'Produto sem informações', 'Sim', 'Acessorios', '10', 'kg', '10', 'm', '10', 'm', '10', 'm', '10', 'm', '10', 'm', 'Descricao', '2017-05-15', '21:31:00', 'Funcionario 1', '1254964578', 'Gerente', 2),
('7001296852', 'Nome3', 'Marca3', 'Lote132', 101, 'unidade(s)', '12523', '2016-07-16', '2016-01-10', '2016-01-16', '2', 'ano(s)', 10, 20, 'Nacional', '10', 'ano(s)', 'Fornecedor3', '12.312.321/3213-9', 'Tipo de produto 3', 1, 'Aplicacao 3', 'Não', 'Produto sem informações', 'Não', 'Produto sem informações', 'Produto sem informações', 'Produto sem informações', 'Não', 'Acessorios', '0', 'Não determinada', '10', 'm', '0', 'Não determinada', '0', 'Não determinada', '0', 'Não determinada', '0', 'Não determinada', 'Descricao', '2017-05-15', '21:33:00', 'Funcionario 1', '1254964578', 'Gerente', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `promocaolistatb`
--

CREATE TABLE `promocaolistatb` (
  `codigoproduto_promo_lis` varchar(50) DEFAULT NULL,
  `nomeproduto_promo_lis` varchar(100) DEFAULT NULL,
  `preconormal_promo_lis` double DEFAULT NULL,
  `precodesconto_promo_lis` double DEFAULT NULL,
  `desconto_promo_lis` double DEFAULT NULL,
  `codigopromocao_promo_lis` varchar(50) DEFAULT NULL,
  `promocaolista_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `promocaotb`
--

CREATE TABLE `promocaotb` (
  `codigopromocao_promo` varchar(50) DEFAULT NULL,
  `estadopromocao_promo` varchar(50) DEFAULT NULL,
  `nomepromocao_promo` varchar(100) DEFAULT NULL,
  `descricao_promo` text,
  `tipopromocao_promo` varchar(100) DEFAULT NULL,
  `datainicio_promo` date DEFAULT NULL,
  `horainicio_promo` time DEFAULT NULL,
  `datatermino_promo` date DEFAULT NULL,
  `horatermino_promo` time DEFAULT NULL,
  `datacadastro_promo` date DEFAULT NULL,
  `horacadastro_promo` time DEFAULT NULL,
  `nomeresponsavel_promo` varchar(100) DEFAULT NULL,
  `cargoresponsavel_promo` varchar(50) DEFAULT NULL,
  `codigoresponsavel_promo` varchar(50) DEFAULT NULL,
  `funcionariocadastro_promo` varchar(100) DEFAULT NULL,
  `cargofuncionario_promo` varchar(20) DEFAULT NULL,
  `codigofuncionario_promo` varchar(50) DEFAULT NULL,
  `promocao_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `transportetb`
--

CREATE TABLE `transportetb` (
  `codigotransporte_transp` varchar(50) DEFAULT NULL,
  `clientenome_transp` varchar(100) DEFAULT NULL,
  `cpfcliente_transp` varchar(50) DEFAULT NULL,
  `rgcliente_transp` varchar(50) DEFAULT NULL,
  `enderecocliente_transp` varchar(100) DEFAULT NULL,
  `numerocliente_transp` varchar(50) DEFAULT NULL,
  `bairrocliente_transp` varchar(50) DEFAULT NULL,
  `cidadecliente_transp` varchar(50) DEFAULT NULL,
  `nomeresponsavel_transp` varchar(100) DEFAULT NULL,
  `cargoresponsavel_transp` varchar(20) DEFAULT NULL,
  `codigoresponsavel_transp` varchar(50) DEFAULT NULL,
  `codigovenda_transp` varchar(50) DEFAULT NULL,
  `estadocarga_transp` varchar(50) DEFAULT NULL,
  `tipotransporte_transp` varchar(20) DEFAULT NULL,
  `datasaida_transp` date DEFAULT NULL,
  `horasaida_transp` time DEFAULT NULL,
  `datachegada_transp` date DEFAULT NULL,
  `horachegada_transp` time DEFAULT NULL,
  `funcionarionome_transp` varchar(100) DEFAULT NULL,
  `cargofuncionario_transp` varchar(50) DEFAULT NULL,
  `codigofuncionario_transp` varchar(50) DEFAULT NULL,
  `datacadastro_transp` date DEFAULT NULL,
  `horacadastro_transp` time DEFAULT NULL,
  `transporte_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `transportetb`
--

INSERT INTO `transportetb` (`codigotransporte_transp`, `clientenome_transp`, `cpfcliente_transp`, `rgcliente_transp`, `enderecocliente_transp`, `numerocliente_transp`, `bairrocliente_transp`, `cidadecliente_transp`, `nomeresponsavel_transp`, `cargoresponsavel_transp`, `codigoresponsavel_transp`, `codigovenda_transp`, `estadocarga_transp`, `tipotransporte_transp`, `datasaida_transp`, `horasaida_transp`, `datachegada_transp`, `horachegada_transp`, `funcionarionome_transp`, `cargofuncionario_transp`, `codigofuncionario_transp`, `datacadastro_transp`, `horacadastro_transp`, `transporte_id`) VALUES
('7303775280', 'Cliente 1', '850.045.405-2', '84.553.058-0', 'Endereço do Cliente 1', '967', 'Bairro do Cliente 1', 'Cidade do Cliente 1', 'Funcionario 1', 'Gerente', '0558228497', '8313551608', 'Em transito', 'Caminhão', '2017-02-10', '10:00:00', '2017-02-10', '10:30:00', 'Funcionario 1', 'Gerente', '0558228497', '2017-05-16', '20:05:00', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendalistaprodutotb`
--

CREATE TABLE `vendalistaprodutotb` (
  `codigoproduto_lis_ven` varchar(50) DEFAULT NULL,
  `produto_lis_ven` varchar(100) DEFAULT NULL,
  `quantidade_lis_ven` double DEFAULT NULL,
  `precounitario_lis_ven` double DEFAULT NULL,
  `precoquantidade_lis_ven` double DEFAULT NULL,
  `codigovenda_lis_ven` varchar(50) DEFAULT NULL,
  `vendalistaproduto_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendalistaprodutotb`
--

INSERT INTO `vendalistaprodutotb` (`codigoproduto_lis_ven`, `produto_lis_ven`, `quantidade_lis_ven`, `precounitario_lis_ven`, `precoquantidade_lis_ven`, `codigovenda_lis_ven`, `vendalistaproduto_id`) VALUES
('9359551194', 'Nome1', 1, 20, 20, '8313551608', 1),
('0114618403', 'Nome2', 1, 20, 20, '8313551608', 2),
('7001296852', 'Nome3', 1, 20, 20, '8313551608', 3),
('9359551194', 'Nome1', 1, 20, 20, '3540814914', 4),
('0114618403', 'Nome2', 1, 20, 20, '3540814914', 5),
('7001296852', 'Nome3', 1, 20, 20, '3540814914', 6),
('9359551194', 'Nome1', 1, 20, 20, '6157962886', 7),
('0114618403', 'Nome2', 1, 20, 20, '6157962886', 8),
('7001296852', 'Nome3', 1, 20, 20, '6157962886', 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendatb`
--

CREATE TABLE `vendatb` (
  `codigovenda_ven` varchar(50) DEFAULT NULL,
  `nomefuncionario_ven` varchar(100) DEFAULT NULL,
  `cargofuncionario_ven` varchar(20) DEFAULT NULL,
  `codigofuncionario_ven` varchar(50) DEFAULT NULL,
  `nomecliente_ven` varchar(100) DEFAULT NULL,
  `cpfcliente_ven` varchar(50) DEFAULT NULL,
  `codigocliente_ven` varchar(50) DEFAULT NULL,
  `tipopagamento_ven` varchar(30) DEFAULT NULL,
  `metodopagamento_ven` varchar(30) DEFAULT NULL,
  `datavenda_ven` date DEFAULT NULL,
  `horavenda_ven` time DEFAULT NULL,
  `notafiscalpaulista_ven` varchar(20) DEFAULT NULL,
  `valortotal_ven` double DEFAULT NULL,
  `descontoporcentagem_ven` double DEFAULT NULL,
  `valortotaldesconto_ven` double DEFAULT NULL,
  `quantidadeparcelas_ven` int(10) DEFAULT NULL,
  `valortotalparcelado_ven` double DEFAULT NULL,
  `venda_id` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendatb`
--

INSERT INTO `vendatb` (`codigovenda_ven`, `nomefuncionario_ven`, `cargofuncionario_ven`, `codigofuncionario_ven`, `nomecliente_ven`, `cpfcliente_ven`, `codigocliente_ven`, `tipopagamento_ven`, `metodopagamento_ven`, `datavenda_ven`, `horavenda_ven`, `notafiscalpaulista_ven`, `valortotal_ven`, `descontoporcentagem_ven`, `valortotaldesconto_ven`, `quantidadeparcelas_ven`, `valortotalparcelado_ven`, `venda_id`) VALUES
('8313551608', 'Funcionario 1', 'Gerente', '0558228497', 'Cliente 1', '850.045.405-2', '2210762392', 'Cartão de credito', 'À vista', '2016-10-12', '14:00:00', 'Pedido', 60, 50, 30, 0, 0, 1),
('3540814914', 'Funcionario 1', 'Gerente', '0558228497', 'Cliente 1', '850.045.405-2', '2210762392', 'Cartão de credito', 'À vista', '2016-02-14', '15:00:00', 'Pedido', 60, 50, 30, 0, 0, 2),
('6157962886', 'Funcionario 1', 'Gerente', '0558228497', 'Cliente 1', '850.045.405-2', '2210762392', 'Cartão de credito', 'À vista', '2016-07-12', '15:00:00', 'Pedido', 60, 10, 54, 0, 0, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acessologtb`
--
ALTER TABLE `acessologtb`
  ADD PRIMARY KEY (`acessolog_id`);

--
-- Indexes for table `clientetb`
--
ALTER TABLE `clientetb`
  ADD PRIMARY KEY (`cliente_id`);

--
-- Indexes for table `compralistaprodutotb`
--
ALTER TABLE `compralistaprodutotb`
  ADD PRIMARY KEY (`compralistaproduto_id`);

--
-- Indexes for table `compratb`
--
ALTER TABLE `compratb`
  ADD PRIMARY KEY (`compra_id`);

--
-- Indexes for table `controleferiastb`
--
ALTER TABLE `controleferiastb`
  ADD PRIMARY KEY (`controleferias_id`);

--
-- Indexes for table `dadoslojatb`
--
ALTER TABLE `dadoslojatb`
  ADD PRIMARY KEY (`lojadados_id`);

--
-- Indexes for table `descontotb`
--
ALTER TABLE `descontotb`
  ADD PRIMARY KEY (`desconto_id`);

--
-- Indexes for table `estoqueprodutotb`
--
ALTER TABLE `estoqueprodutotb`
  ADD PRIMARY KEY (`estoqueproduto_id`);

--
-- Indexes for table `fornecedortb`
--
ALTER TABLE `fornecedortb`
  ADD PRIMARY KEY (`fornecedor_id`);

--
-- Indexes for table `funcionariohistoricolistafaltastb`
--
ALTER TABLE `funcionariohistoricolistafaltastb`
  ADD PRIMARY KEY (`historicolistafalta_id`);

--
-- Indexes for table `funcionariohistoricotb`
--
ALTER TABLE `funcionariohistoricotb`
  ADD PRIMARY KEY (`funcionariohistorico_id`);

--
-- Indexes for table `funcionariosalariotb`
--
ALTER TABLE `funcionariosalariotb`
  ADD PRIMARY KEY (`funcionariosalario_id`);

--
-- Indexes for table `funcionariotb`
--
ALTER TABLE `funcionariotb`
  ADD PRIMARY KEY (`funcionario_id`);

--
-- Indexes for table `historicoreposicaoestoquetb`
--
ALTER TABLE `historicoreposicaoestoquetb`
  ADD PRIMARY KEY (`historicoreposicaoestoque_id`);

--
-- Indexes for table `historicovendatb`
--
ALTER TABLE `historicovendatb`
  ADD PRIMARY KEY (`historicovenda_id`);

--
-- Indexes for table `notafiscaltb`
--
ALTER TABLE `notafiscaltb`
  ADD PRIMARY KEY (`notafiscal_id`);

--
-- Indexes for table `produtotb`
--
ALTER TABLE `produtotb`
  ADD PRIMARY KEY (`produto_id`);

--
-- Indexes for table `promocaolistatb`
--
ALTER TABLE `promocaolistatb`
  ADD PRIMARY KEY (`promocaolista_id`);

--
-- Indexes for table `promocaotb`
--
ALTER TABLE `promocaotb`
  ADD PRIMARY KEY (`promocao_id`);

--
-- Indexes for table `transportetb`
--
ALTER TABLE `transportetb`
  ADD PRIMARY KEY (`transporte_id`);

--
-- Indexes for table `vendalistaprodutotb`
--
ALTER TABLE `vendalistaprodutotb`
  ADD PRIMARY KEY (`vendalistaproduto_id`);

--
-- Indexes for table `vendatb`
--
ALTER TABLE `vendatb`
  ADD PRIMARY KEY (`venda_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `acessologtb`
--
ALTER TABLE `acessologtb`
  MODIFY `acessolog_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `clientetb`
--
ALTER TABLE `clientetb`
  MODIFY `cliente_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `compralistaprodutotb`
--
ALTER TABLE `compralistaprodutotb`
  MODIFY `compralistaproduto_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `compratb`
--
ALTER TABLE `compratb`
  MODIFY `compra_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `controleferiastb`
--
ALTER TABLE `controleferiastb`
  MODIFY `controleferias_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `dadoslojatb`
--
ALTER TABLE `dadoslojatb`
  MODIFY `lojadados_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `descontotb`
--
ALTER TABLE `descontotb`
  MODIFY `desconto_id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `estoqueprodutotb`
--
ALTER TABLE `estoqueprodutotb`
  MODIFY `estoqueproduto_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `fornecedortb`
--
ALTER TABLE `fornecedortb`
  MODIFY `fornecedor_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `funcionariohistoricolistafaltastb`
--
ALTER TABLE `funcionariohistoricolistafaltastb`
  MODIFY `historicolistafalta_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `funcionariohistoricotb`
--
ALTER TABLE `funcionariohistoricotb`
  MODIFY `funcionariohistorico_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `funcionariosalariotb`
--
ALTER TABLE `funcionariosalariotb`
  MODIFY `funcionariosalario_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `funcionariotb`
--
ALTER TABLE `funcionariotb`
  MODIFY `funcionario_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `historicoreposicaoestoquetb`
--
ALTER TABLE `historicoreposicaoestoquetb`
  MODIFY `historicoreposicaoestoque_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `historicovendatb`
--
ALTER TABLE `historicovendatb`
  MODIFY `historicovenda_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `notafiscaltb`
--
ALTER TABLE `notafiscaltb`
  MODIFY `notafiscal_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `produtotb`
--
ALTER TABLE `produtotb`
  MODIFY `produto_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `promocaolistatb`
--
ALTER TABLE `promocaolistatb`
  MODIFY `promocaolista_id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `promocaotb`
--
ALTER TABLE `promocaotb`
  MODIFY `promocao_id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transportetb`
--
ALTER TABLE `transportetb`
  MODIFY `transporte_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `vendalistaprodutotb`
--
ALTER TABLE `vendalistaprodutotb`
  MODIFY `vendalistaproduto_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `vendatb`
--
ALTER TABLE `vendatb`
  MODIFY `venda_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
