/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : diaryboard_prod

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-03-02 19:29:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aposta
-- ----------------------------
DROP TABLE IF EXISTS `aposta`;
CREATE TABLE `aposta` (
  `APOS_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `APOS_DT_APOSTA` datetime DEFAULT NULL,
  `APOS_DS_RESULTADO` varchar(255) DEFAULT NULL,
  `APOS_FL_RESOLVIDA` bit(1) DEFAULT NULL,
  `APOS_CD_ID_TICKET` varchar(255) DEFAULT NULL,
  `APOS_VL_APOSTA` decimal(19,2) DEFAULT NULL,
  `APOS_VL_RETORNO` decimal(19,2) DEFAULT NULL,
  `BET_CD_ID_FK` bigint(20) DEFAULT NULL,
  `PLJI_CD_ID_FK` bigint(20) NOT NULL,
  `TIPS_CD_ID_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`APOS_CD_ID_PK`),
  UNIQUE KEY `UK_fap55olwleejj1se3lq1qqeta` (`APOS_CD_ID_TICKET`),
  KEY `FK_knppmr53ll4rtr1ycjb8f0dqw` (`BET_CD_ID_FK`),
  KEY `FK_h8yd2yr3s604gglcgmhuoxpws` (`PLJI_CD_ID_FK`),
  KEY `FK_htmftqag1t0iub80cdyrt1y2` (`TIPS_CD_ID_FK`),
  CONSTRAINT `FK_h8yd2yr3s604gglcgmhuoxpws` FOREIGN KEY (`PLJI_CD_ID_FK`) REFERENCES `plano_jogo_item` (`PLJI_CD_ID_PK`),
  CONSTRAINT `FK_htmftqag1t0iub80cdyrt1y2` FOREIGN KEY (`TIPS_CD_ID_FK`) REFERENCES `tipster` (`TIPS_CD_ID_PK`),
  CONSTRAINT `FK_knppmr53ll4rtr1ycjb8f0dqw` FOREIGN KEY (`BET_CD_ID_FK`) REFERENCES `bet` (`BET_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aposta
-- ----------------------------
INSERT INTO `aposta` VALUES ('1', '2015-02-28 21:00:00', 'GANHOU', '\0', '1425329562929', '10.00', '14.45', '1', '1', '1');
INSERT INTO `aposta` VALUES ('2', '2015-02-28 21:00:00', 'GANHOU', '\0', '1425329619534', '20.00', '25.00', '2', '2', '1');
INSERT INTO `aposta` VALUES ('3', '2015-02-28 21:00:00', 'GANHOU', '\0', '1425329797124', '100.00', '148.87', '3', '31', '1');
INSERT INTO `aposta` VALUES ('4', '2015-03-01 21:00:00', 'GANHOU', '\0', '1425329991079', '19.45', '27.23', '4', '3', '1');

-- ----------------------------
-- Table structure for bandeira
-- ----------------------------
DROP TABLE IF EXISTS `bandeira`;
CREATE TABLE `bandeira` (
  `BAND_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `BAND_DS_COMPETICAO` varchar(255) DEFAULT NULL,
  `BAND_DS_IMAGEM` varchar(255) DEFAULT NULL,
  `BAND_DS_URLIMAGEM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BAND_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bandeira
-- ----------------------------
INSERT INTO `bandeira` VALUES ('174', 'Alemanha - 2. Bundesliga', 'Alemanha - 2. Bundesliga.gif', '/resources/images/flags/174.gif');
INSERT INTO `bandeira` VALUES ('175', 'Alemanha - Bundesliga', 'Alemanha - Bundesliga.gif', '/resources/images/flags/175.gif');
INSERT INTO `bandeira` VALUES ('176', 'Argentina - Primeira B Nacional', 'Argentina - Primeira B Nacional.gif', '/resources/images/flags/176.gif');
INSERT INTO `bandeira` VALUES ('177', 'Argentina - Primeira Divisão', 'Argentina - Primeira Divisão.gif', '/resources/images/flags/177.gif');
INSERT INTO `bandeira` VALUES ('178', 'Brasil - Série A', 'Brasil - Série A.gif', '/resources/images/flags/178.gif');
INSERT INTO `bandeira` VALUES ('179', 'Brasil - Série B', 'Brasil - Série B.gif', '/resources/images/flags/179.gif');
INSERT INTO `bandeira` VALUES ('180', 'Bélgica - Primeira Liga', 'Bélgica - Primeira Liga.gif', '/resources/images/flags/180.gif');
INSERT INTO `bandeira` VALUES ('181', 'China - CSL Super Liga', 'China - CSL Super Liga.gif', '/resources/images/flags/181.gif');
INSERT INTO `bandeira` VALUES ('182', 'Chipre - Primeira Divisão', 'Chipre - Primeira Divisão.gif', '/resources/images/flags/182.gif');
INSERT INTO `bandeira` VALUES ('183', 'Coreia do Sul - Primeira Liga', 'Coreia do Sul - Primeira Liga.gif', '/resources/images/flags/183.gif');
INSERT INTO `bandeira` VALUES ('184', 'Dinamarca - Super Liga', 'Dinamarca - Super Liga.gif', '/resources/images/flags/184.gif');
INSERT INTO `bandeira` VALUES ('185', 'Escócia - Primeira Liga', 'Escócia - Primeira Liga.gif', '/resources/images/flags/185.gif');
INSERT INTO `bandeira` VALUES ('186', 'Espanha - Primeira Divisão', 'Espanha - Primeira Divisão.gif', '/resources/images/flags/186.gif');
INSERT INTO `bandeira` VALUES ('187', 'Espanha - Segunda Divisão', 'Espanha - Segunda Divisão.gif', '/resources/images/flags/187.gif');
INSERT INTO `bandeira` VALUES ('188', 'Estados Unidos da América - MLS Primeira Liga', 'Estados Unidos da América - MLS Primeira Liga.gif', '/resources/images/flags/188.gif');
INSERT INTO `bandeira` VALUES ('189', 'França - Ligue 1', 'França - Ligue 1.gif', '/resources/images/flags/189.gif');
INSERT INTO `bandeira` VALUES ('190', 'França - Ligue 2', 'França - Ligue 2.gif', '/resources/images/flags/190.gif');
INSERT INTO `bandeira` VALUES ('191', 'Grécia - Segunda Liga', 'Grécia - Segunda Liga.gif', '/resources/images/flags/191.gif');
INSERT INTO `bandeira` VALUES ('192', 'Grécia - Super Liga', 'Grécia - Super Liga.gif', '/resources/images/flags/192.gif');
INSERT INTO `bandeira` VALUES ('193', 'Holanda - Eredivisie', 'Holanda - Eredivisie.gif', '/resources/images/flags/193.gif');
INSERT INTO `bandeira` VALUES ('194', 'Holanda - Segunda Liga', 'Holanda - Segunda Liga.gif', '/resources/images/flags/194.gif');
INSERT INTO `bandeira` VALUES ('195', 'Hungria - NB I Primeira Liga', 'Hungria - NB I Primeira Liga.gif', '/resources/images/flags/195.gif');
INSERT INTO `bandeira` VALUES ('196', 'Inglaterra - 2. Championship', 'Inglaterra - 2. Championship.gif', '/resources/images/flags/196.gif');
INSERT INTO `bandeira` VALUES ('197', 'Inglaterra - 3. League One', 'Inglaterra - 3. League One.gif', '/resources/images/flags/197.gif');
INSERT INTO `bandeira` VALUES ('198', 'Inglaterra - Premier League', 'Inglaterra - Premier League.gif', '/resources/images/flags/198.gif');
INSERT INTO `bandeira` VALUES ('199', 'Irlanda - Primeira Divisão', 'Irlanda - Primeira Divisão.gif', '/resources/images/flags/199.gif');
INSERT INTO `bandeira` VALUES ('200', 'Itália - Série A', 'Itália - Série A.gif', '/resources/images/flags/200.gif');
INSERT INTO `bandeira` VALUES ('201', 'Itália - Série B', 'Itália - Série B.gif', '/resources/images/flags/201.gif');
INSERT INTO `bandeira` VALUES ('202', 'Japão - J1 Primeira Liga', 'Japão - J1 Primeira Liga.gif', '/resources/images/flags/202.gif');
INSERT INTO `bandeira` VALUES ('203', 'Japão - J2 Segunda Liga', 'Japão - J2 Segunda Liga.gif', '/resources/images/flags/203.gif');
INSERT INTO `bandeira` VALUES ('204', 'Noruega - Primeira Liga', 'Noruega - Primeira Liga.gif', '/resources/images/flags/204.gif');
INSERT INTO `bandeira` VALUES ('205', 'Polónia - Primeira Liga', 'Polónia - Primeira Liga.gif', '/resources/images/flags/205.gif');
INSERT INTO `bandeira` VALUES ('206', 'Portugal - Primeira Liga', 'Portugal - Primeira Liga.gif', '/resources/images/flags/206.gif');
INSERT INTO `bandeira` VALUES ('207', 'Portugal - Segunda Liga', 'Portugal - Segunda Liga.gif', '/resources/images/flags/207.gif');
INSERT INTO `bandeira` VALUES ('208', 'República Checa - Primeira Liga', 'República Checa - Primeira Liga.gif', '/resources/images/flags/208.gif');
INSERT INTO `bandeira` VALUES ('209', 'Roménia - Primeira Liga', 'Roménia - Primeira Liga.gif', '/resources/images/flags/209.gif');
INSERT INTO `bandeira` VALUES ('210', 'Rússia - FNL Segunda Liga', 'Rússia - FNL Segunda Liga.gif', '/resources/images/flags/210.gif');
INSERT INTO `bandeira` VALUES ('211', 'Rússia - Primeira Liga', 'Rússia - Primeira Liga.gif', '/resources/images/flags/211.gif');
INSERT INTO `bandeira` VALUES ('212', 'Suécia - Primeira Liga', 'Suécia - Primeira Liga.gif', '/resources/images/flags/212.gif');
INSERT INTO `bandeira` VALUES ('213', 'Suíça - Super Liga', 'Suíça - Super Liga.gif', '/resources/images/flags/213.gif');
INSERT INTO `bandeira` VALUES ('214', 'Turquia - Super Liga', 'Turquia - Super Liga.gif', '/resources/images/flags/214.gif');
INSERT INTO `bandeira` VALUES ('215', 'Ucrânia - Primeira Liga', 'Ucrânia - Primeira Liga.gif', '/resources/images/flags/215.gif');
INSERT INTO `bandeira` VALUES ('216', 'Azerbaijão - Premier League', 'Azerbaijão - Premier League.gif', '/resources/images/flags/216.gif');
INSERT INTO `bandeira` VALUES ('217', 'Bielorrusia - Premier League', 'Bielorrusia - Premier League.jpg', '/resources/images/flags/217.gif');
INSERT INTO `bandeira` VALUES ('218', 'Bulgária - A PFG Primeira Liga', 'Bulgária - A PFG Primeira Liga.gif', '/resources/images/flags/218.gif');
INSERT INTO `bandeira` VALUES ('219', 'Bósnia - Premier League', 'Bósnia - Premier League.gif', '/resources/images/flags/219.gif');
INSERT INTO `bandeira` VALUES ('220', 'Croácia - 1. HNL Primeira Liga', 'Croácia - 1. HNL Primeira Liga.gif', '/resources/images/flags/220.gif');
INSERT INTO `bandeira` VALUES ('221', 'México - Primeira Liga', 'México - Primeira Liga.gif', '/resources/images/flags/129.gif');
INSERT INTO `bandeira` VALUES ('222', 'Venezuela - Primeira Divisão', 'Venezuela - Primeira Divisão.gif', '/resources/images/flags/999.gif');

-- ----------------------------
-- Table structure for bet
-- ----------------------------
DROP TABLE IF EXISTS `bet`;
CREATE TABLE `bet` (
  `BET_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `CAMP_CD_ID_FK` bigint(20) NOT NULL,
  `EVEN_CD_ID_FK` bigint(20) NOT NULL,
  PRIMARY KEY (`BET_CD_ID_PK`),
  KEY `FK_6rxfauff7jxdkfmvi4gdqyqat` (`CAMP_CD_ID_FK`),
  KEY `FK_f3p6wnpve0jlsl30ya2631grh` (`EVEN_CD_ID_FK`),
  CONSTRAINT `FK_6rxfauff7jxdkfmvi4gdqyqat` FOREIGN KEY (`CAMP_CD_ID_FK`) REFERENCES `campeonato` (`CAMP_CD_ID_PK`),
  CONSTRAINT `FK_f3p6wnpve0jlsl30ya2631grh` FOREIGN KEY (`EVEN_CD_ID_FK`) REFERENCES `evento` (`EVEN_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bet
-- ----------------------------
INSERT INTO `bet` VALUES ('1', '18', '1');
INSERT INTO `bet` VALUES ('2', '19', '2');
INSERT INTO `bet` VALUES ('3', '20', '3');
INSERT INTO `bet` VALUES ('4', '3', '4');

-- ----------------------------
-- Table structure for caixa_aposta
-- ----------------------------
DROP TABLE IF EXISTS `caixa_aposta`;
CREATE TABLE `caixa_aposta` (
  `CAAP_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `CAAP_DT_MOVIMENTACAO` datetime DEFAULT NULL,
  `CAAP_DS_MOVIMENTACAO` varchar(255) DEFAULT NULL,
  `CAAP_VL_MOVIMENTACAO` decimal(19,2) DEFAULT NULL,
  `CAAP_VL_SALDO_PARA_JOGO` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`CAAP_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of caixa_aposta
-- ----------------------------
INSERT INTO `caixa_aposta` VALUES ('1', '2015-02-28 21:00:00', 'DEPOSITO', '607.92', '607.92');
INSERT INTO `caixa_aposta` VALUES ('2', '2015-03-02 17:51:40', 'SAIDA_PLANO', '10.00', '597.92');
INSERT INTO `caixa_aposta` VALUES ('3', '2015-03-02 17:54:55', 'SAIDA_PLANO', '100.00', '497.92');

-- ----------------------------
-- Table structure for campeonato
-- ----------------------------
DROP TABLE IF EXISTS `campeonato`;
CREATE TABLE `campeonato` (
  `CAMP_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `CAMP_DS_SIGLA` varchar(255) DEFAULT NULL,
  `CAMP_DS_URL_COMPETICAO` varchar(255) DEFAULT NULL,
  `BAND_DS_FLAG` bigint(20) DEFAULT NULL,
  `CAMP_FL_ACADEMIA` tinyint(1) DEFAULT NULL,
  `CAMP_FL_PROSOCCER` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`CAMP_CD_ID_PK`),
  KEY `FKD581E4D9DDFFDE98` (`BAND_DS_FLAG`),
  CONSTRAINT `FKD581E4D9DDFFDE98` FOREIGN KEY (`BAND_DS_FLAG`) REFERENCES `bandeira` (`BAND_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of campeonato
-- ----------------------------
INSERT INTO `campeonato` VALUES ('2', 'IT1', 'http://www.academiadasapostas.com/stats/competition/italia/13', '200', '1', '1');
INSERT INTO `campeonato` VALUES ('3', 'ES1', '', '186', '1', '1');
INSERT INTO `campeonato` VALUES ('4', 'BA1', '', '219', '0', '1');
INSERT INTO `campeonato` VALUES ('5', 'PT1', '', '206', '1', '1');
INSERT INTO `campeonato` VALUES ('6', 'AZ1', '', '216', '0', '1');
INSERT INTO `campeonato` VALUES ('7', 'BY1', '', '217', '0', '1');
INSERT INTO `campeonato` VALUES ('8', 'BE1', '', '180', '1', '1');
INSERT INTO `campeonato` VALUES ('9', 'BG1', '', '218', '1', '1');
INSERT INTO `campeonato` VALUES ('10', 'CZ1', '', '208', '1', '1');
INSERT INTO `campeonato` VALUES ('11', 'HR1', '', '195', '1', '1');
INSERT INTO `campeonato` VALUES ('12', 'NE1', '', '193', '1', '1');
INSERT INTO `campeonato` VALUES ('13', 'GR1', '', '192', '1', '1');
INSERT INTO `campeonato` VALUES ('14', 'BR1', '', '178', '1', '1');
INSERT INTO `campeonato` VALUES ('15', 'DE1', 'https://www.academiadasapostas.com/stats/competition/alemanha-stats/9', '175', '1', '1');
INSERT INTO `campeonato` VALUES ('16', 'ENP', 'https://www.academiadasapostas.com/stats/competition/inglaterra-stats/8', '198', '1', '1');
INSERT INTO `campeonato` VALUES ('17', 'FR1', 'https://www.academiadasapostas.com/stats/competition/franca/16', '189', '1', '1');
INSERT INTO `campeonato` VALUES ('18', 'VZ1', '', '222', '0', '0');
INSERT INTO `campeonato` VALUES ('19', 'MX1', 'https://www.academiadasapostas.com/stats/competition/mexico/155', '221', '1', '1');
INSERT INTO `campeonato` VALUES ('20', 'RS1', 'https://www.academiadasapostas.com/stats/competition/russia-stats/121/9827/25305', '211', '1', '1');

-- ----------------------------
-- Table structure for evento
-- ----------------------------
DROP TABLE IF EXISTS `evento`;
CREATE TABLE `evento` (
  `EVEN_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `EVEN_DT_EVENTO` datetime DEFAULT NULL,
  `EVEN_DS_TIMECASA` varchar(255) DEFAULT NULL,
  `EVEN_DS_TIMEVISITANTE` varchar(255) DEFAULT NULL,
  `EVEN_DS_EVENTO` varchar(255) DEFAULT NULL,
  `EVEN_NM_ODD` decimal(19,2) DEFAULT NULL,
  `MEAP_CD_ID_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`EVEN_CD_ID_PK`),
  KEY `FK_i1l7vtu49vpc7p5f5eb6sk67e` (`MEAP_CD_ID_FK`),
  CONSTRAINT `FK_i1l7vtu49vpc7p5f5eb6sk67e` FOREIGN KEY (`MEAP_CD_ID_FK`) REFERENCES `mercado_aposta` (`MEAP_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evento
-- ----------------------------
INSERT INTO `evento` VALUES ('1', null, 'ZAMORA', 'TUCANES', 'ZAMORA vs TUCANES', '1.45', '9');
INSERT INTO `evento` VALUES ('2', null, 'CHIVAS GUADALAJARA', 'MONTERREY', 'CHIVAS GUADALAJARA vs MONTERREY', '1.25', '7');
INSERT INTO `evento` VALUES ('3', null, 'CSKA MOSCOVO', 'KRYLYA SAMARA', 'CSKA MOSCOVO vs KRYLYA SAMARA', '1.49', '1');
INSERT INTO `evento` VALUES ('4', null, 'CELTA DE VIGO', 'ELCHE', 'CELTA DE VIGO vs ELCHE', '1.40', '5');

-- ----------------------------
-- Table structure for mercado_aposta
-- ----------------------------
DROP TABLE IF EXISTS `mercado_aposta`;
CREATE TABLE `mercado_aposta` (
  `MEAP_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `MEAP_DS_DESCRICAO` varchar(255) DEFAULT NULL,
  `MEAS_CD_ID_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`MEAP_CD_ID_PK`),
  KEY `FK33FFB59CDED8F71` (`MEAS_CD_ID_FK`),
  CONSTRAINT `FK33FFB59CDED8F71` FOREIGN KEY (`MEAS_CD_ID_FK`) REFERENCES `mercado_aposta_selecao` (`MEAS_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mercado_aposta
-- ----------------------------
INSERT INTO `mercado_aposta` VALUES ('1', 'Time da Casa', '1');
INSERT INTO `mercado_aposta` VALUES ('2', 'Empate', '1');
INSERT INTO `mercado_aposta` VALUES ('3', 'Time Visitante', '1');
INSERT INTO `mercado_aposta` VALUES ('5', 'Mais de 0.5', '2');
INSERT INTO `mercado_aposta` VALUES ('6', 'Menos de 0.5', '2');
INSERT INTO `mercado_aposta` VALUES ('7', 'Mais de 1.5', '2');
INSERT INTO `mercado_aposta` VALUES ('8', 'Menos de 1.5', '2');
INSERT INTO `mercado_aposta` VALUES ('9', 'Mais de 2.5', '2');
INSERT INTO `mercado_aposta` VALUES ('10', 'Menos de 2.5', '2');
INSERT INTO `mercado_aposta` VALUES ('11', 'Mais de 3.5', '2');
INSERT INTO `mercado_aposta` VALUES ('12', 'Menos de 3.5', '2');
INSERT INTO `mercado_aposta` VALUES ('13', 'Mais de 4.5', '2');
INSERT INTO `mercado_aposta` VALUES ('14', 'Menos de 4.5', '2');
INSERT INTO `mercado_aposta` VALUES ('15', 'Mais de 5.5', '2');
INSERT INTO `mercado_aposta` VALUES ('16', 'Menos de 5.5', '2');
INSERT INTO `mercado_aposta` VALUES ('17', 'Mais de 6.5', '2');
INSERT INTO `mercado_aposta` VALUES ('18', 'Menos de 6.5', '2');
INSERT INTO `mercado_aposta` VALUES ('19', 'Mais de 7.5', '2');
INSERT INTO `mercado_aposta` VALUES ('20', 'Menos de 7.5', '2');

-- ----------------------------
-- Table structure for mercado_aposta_selecao
-- ----------------------------
DROP TABLE IF EXISTS `mercado_aposta_selecao`;
CREATE TABLE `mercado_aposta_selecao` (
  `MEAS_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `MEAS_DS_DESCRICAO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MEAS_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mercado_aposta_selecao
-- ----------------------------
INSERT INTO `mercado_aposta_selecao` VALUES ('1', 'Resultado Final');
INSERT INTO `mercado_aposta_selecao` VALUES ('2', 'Gols');
INSERT INTO `mercado_aposta_selecao` VALUES ('3', 'Hipótese Dupla');

-- ----------------------------
-- Table structure for plano_jogo
-- ----------------------------
DROP TABLE IF EXISTS `plano_jogo`;
CREATE TABLE `plano_jogo` (
  `PLJO_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `PLJO_FL_ATIVO` bit(1) DEFAULT NULL,
  `PLJO_DT_CRIACAO` datetime DEFAULT NULL,
  `PLJO_DS_DESCRICAO` varchar(255) DEFAULT NULL,
  `PLJO_NM_DIAS_PLANO` int(11) DEFAULT NULL,
  `PLJO_PC_APOSTA_DIA` decimal(19,2) DEFAULT NULL,
  `PLJO_PC_LUCRO_DIA` decimal(19,2) DEFAULT NULL,
  `PLJO_VL_INVESTIMENTO_INICIAL` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`PLJO_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plano_jogo
-- ----------------------------
INSERT INTO `plano_jogo` VALUES ('1', '', '2014-12-31 22:00:00', 'TIPS_MAR2015_10+', '30', '100.00', '30.00', '10.00');
INSERT INTO `plano_jogo` VALUES ('2', '', '2015-02-28 21:00:00', 'TIPS_MAR2015 - MILAGRE TEAM', '12', '20.00', '30.00', '100.00');

-- ----------------------------
-- Table structure for plano_jogo_item
-- ----------------------------
DROP TABLE IF EXISTS `plano_jogo_item`;
CREATE TABLE `plano_jogo_item` (
  `PLJI_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `PLJI_DS_DESCRICAO` varchar(255) DEFAULT NULL,
  `PLJI_FL_FINALIZADO` bit(1) DEFAULT NULL,
  `PLJI_PC_LUCRO_DIA` decimal(19,2) DEFAULT NULL,
  `PLJI_PC_LUCRO_META` decimal(19,2) DEFAULT NULL,
  `PLJI_PC_OBJETIVO_CONCLUIDO` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_BET_DIA` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_BET_DIA_OBJETIVO` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_FINAL_DIA` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_FINAL_DIA_OBJETIVO` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_INICIAL_DIA` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_INICIAL_DIA_OBJETIVO` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_LUCRO_DIA` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_LUCRO_DIA_OBJETIVO` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_TOTAL_GANHO_DIA` decimal(19,2) DEFAULT NULL,
  `PLJI_VL_TOTAL_PERDIDO_DIA` decimal(19,2) DEFAULT NULL,
  `PLJO_CD_ID_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PLJI_CD_ID_PK`),
  KEY `FK_mdwg3xy6wqlv7htra4a80qn67` (`PLJO_CD_ID_FK`),
  CONSTRAINT `FK_mdwg3xy6wqlv7htra4a80qn67` FOREIGN KEY (`PLJO_CD_ID_FK`) REFERENCES `plano_jogo` (`PLJO_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plano_jogo_item
-- ----------------------------
INSERT INTO `plano_jogo_item` VALUES ('1', 'DIA 1', '', '44.50', '44.50', '111.15', '10.00', '10.00', '14.45', '13.00', '10.00', '10.00', '4.45', '3.00', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('2', 'DIA 2', '', '34.60', '38.46', '115.09', '13.00', '13.00', '19.45', '16.90', '14.45', '13.00', '5.00', '3.90', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('3', 'DIA 3', '', '40.00', '46.04', '123.94', '16.90', '16.90', '27.23', '21.97', '19.45', '16.90', '7.78', '5.07', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('4', 'DIA 4', '\0', '0.00', '0.00', '95.34', '21.97', '21.97', '27.23', '28.56', '27.23', '21.97', '0.00', '6.59', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('5', 'DIA 5', '\0', '0.00', '0.00', '73.34', '28.56', '28.56', '27.23', '37.13', '27.23', '28.56', '0.00', '8.57', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('6', 'DIA 6', '\0', '0.00', '0.00', '56.41', '37.13', '37.13', '27.23', '48.27', '27.23', '37.13', '0.00', '11.14', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('7', 'DIA 7', '\0', '0.00', '0.00', '43.39', '48.27', '48.27', '27.23', '62.75', '27.23', '48.27', '0.00', '14.48', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('8', 'DIA 8', '\0', '0.00', '0.00', '33.38', '62.75', '62.75', '27.23', '81.57', '27.23', '62.75', '0.00', '18.82', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('9', 'DIA 9', '\0', '0.00', '0.00', '25.68', '81.57', '81.57', '27.23', '106.04', '27.23', '81.57', '0.00', '24.47', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('10', 'DIA 10', '\0', '0.00', '0.00', '19.75', '106.04', '106.04', '27.23', '137.85', '27.23', '106.04', '0.00', '31.81', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('11', 'DIA 11', '\0', '0.00', '0.00', '15.19', '137.85', '137.85', '27.23', '179.21', '27.23', '137.85', '0.00', '41.36', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('12', 'DIA 12', '\0', '0.00', '0.00', '11.69', '179.21', '179.21', '27.23', '232.97', '27.23', '179.21', '0.00', '53.76', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('13', 'DIA 13', '\0', '0.00', '0.00', '8.99', '232.97', '232.97', '27.23', '302.86', '27.23', '232.97', '0.00', '69.89', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('14', 'DIA 14', '\0', '0.00', '0.00', '6.92', '302.86', '302.86', '27.23', '393.72', '27.23', '302.86', '0.00', '90.86', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('15', 'DIA 15', '\0', '0.00', '0.00', '5.32', '393.72', '393.72', '27.23', '511.84', '27.23', '393.72', '0.00', '118.12', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('16', 'DIA 16', '\0', '0.00', '0.00', '4.09', '511.84', '511.84', '27.23', '665.39', '27.23', '511.84', '0.00', '153.55', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('17', 'DIA 17', '\0', '0.00', '0.00', '3.15', '665.39', '665.39', '27.23', '865.01', '27.23', '665.39', '0.00', '199.62', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('18', 'DIA 18', '\0', '0.00', '0.00', '2.42', '865.01', '865.01', '27.23', '1124.51', '27.23', '865.01', '0.00', '259.50', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('19', 'DIA 19', '\0', '0.00', '0.00', '1.86', '1124.51', '1124.51', '27.23', '1461.86', '27.23', '1124.51', '0.00', '337.35', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('20', 'DIA 20', '\0', '0.00', '0.00', '1.43', '1461.86', '1461.86', '27.23', '1900.42', '27.23', '1461.86', '0.00', '438.56', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('21', 'DIA 21', '\0', '0.00', '0.00', '1.10', '1900.42', '1900.42', '27.23', '2470.55', '27.23', '1900.42', '0.00', '570.13', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('22', 'DIA 22', '\0', '0.00', '0.00', '0.85', '2470.55', '2470.55', '27.23', '3211.71', '27.23', '2470.55', '0.00', '741.16', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('23', 'DIA 23', '\0', '0.00', '0.00', '0.65', '3211.71', '3211.71', '27.23', '4175.22', '27.23', '3211.71', '0.00', '963.51', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('24', 'DIA 24', '\0', '0.00', '0.00', '0.50', '4175.22', '4175.22', '27.23', '5427.79', '27.23', '4175.22', '0.00', '1252.57', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('25', 'DIA 25', '\0', '0.00', '0.00', '0.39', '5427.79', '5427.79', '27.23', '7056.13', '27.23', '5427.79', '0.00', '1628.34', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('26', 'DIA 26', '\0', '0.00', '0.00', '0.30', '7056.13', '7056.13', '27.23', '9172.97', '27.23', '7056.13', '0.00', '2116.84', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('27', 'DIA 27', '\0', '0.00', '0.00', '0.23', '9172.97', '9172.97', '27.23', '11924.86', '27.23', '9172.97', '0.00', '2751.89', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('28', 'DIA 28', '\0', '0.00', '0.00', '0.18', '11924.86', '11924.86', '27.23', '15502.32', '27.23', '11924.86', '0.00', '3577.46', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('29', 'DIA 29', '\0', '0.00', '0.00', '0.14', '15502.32', '15502.32', '27.23', '20153.02', '27.23', '15502.32', '0.00', '4650.70', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('30', 'DIA 30', '\0', '0.00', '0.00', '0.10', '20153.02', '20153.02', '27.23', '26198.93', '27.23', '20153.02', '0.00', '6045.91', '0.00', '0.00', '1');
INSERT INTO `plano_jogo_item` VALUES ('31', 'DIA 1', '', '48.87', '48.87', '114.52', '20.00', '20.00', '148.87', '130.00', '100.00', '100.00', '48.87', '30.00', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('32', 'DIA 2', '\0', '0.00', '0.00', '88.09', '26.00', '26.00', '148.87', '169.00', '148.87', '130.00', '0.00', '39.00', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('33', 'DIA 3', '\0', '0.00', '0.00', '67.76', '33.80', '33.80', '148.87', '219.70', '148.87', '169.00', '0.00', '50.70', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('34', 'DIA 4', '\0', '0.00', '0.00', '52.12', '43.94', '43.94', '148.87', '285.61', '148.87', '219.70', '0.00', '65.91', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('35', 'DIA 5', '\0', '0.00', '0.00', '40.10', '57.12', '57.12', '148.87', '371.29', '148.87', '285.61', '0.00', '85.68', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('36', 'DIA 6', '\0', '0.00', '0.00', '30.84', '74.26', '74.26', '148.87', '482.68', '148.87', '371.29', '0.00', '111.39', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('37', 'DIA 7', '\0', '0.00', '0.00', '23.73', '96.54', '96.54', '148.87', '627.48', '148.87', '482.68', '0.00', '144.80', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('38', 'DIA 8', '\0', '0.00', '0.00', '18.25', '125.50', '125.50', '148.87', '815.72', '148.87', '627.48', '0.00', '188.24', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('39', 'DIA 9', '\0', '0.00', '0.00', '14.04', '163.14', '163.14', '148.87', '1060.44', '148.87', '815.72', '0.00', '244.72', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('40', 'DIA 10', '\0', '0.00', '0.00', '10.80', '212.09', '212.09', '148.87', '1378.57', '148.87', '1060.44', '0.00', '318.13', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('41', 'DIA 11', '\0', '0.00', '0.00', '8.31', '275.71', '275.71', '148.87', '1792.14', '148.87', '1378.57', '0.00', '413.57', '0.00', '0.00', '2');
INSERT INTO `plano_jogo_item` VALUES ('42', 'DIA 12', '\0', '0.00', '0.00', '6.39', '358.43', '358.43', '148.87', '2329.78', '148.87', '1792.14', '0.00', '537.64', '0.00', '0.00', '2');

-- ----------------------------
-- Table structure for tipster
-- ----------------------------
DROP TABLE IF EXISTS `tipster`;
CREATE TABLE `tipster` (
  `TIPS_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `TIPS_DS_NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TIPS_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tipster
-- ----------------------------
INSERT INTO `tipster` VALUES ('1', 'Christopher');
INSERT INTO `tipster` VALUES ('2', 'Fernando');
