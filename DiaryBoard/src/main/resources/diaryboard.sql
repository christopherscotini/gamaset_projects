/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : diaryboard

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-02-09 10:35:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aposta
-- ----------------------------
DROP TABLE IF EXISTS `aposta`;
CREATE TABLE `aposta` (
  `APOS_CD_ID_PK` varchar(255) NOT NULL,
  `APOS_FL_MULTIPLA` bit(1) DEFAULT NULL,
  `APOS_DT_APOSTA` datetime DEFAULT NULL,
  `APOS_FL_RESOLVIDA` bit(1) DEFAULT NULL,
  `APOS_VL_APOSTA` decimal(19,2) DEFAULT NULL,
  `APOS_VL_RETORNO` decimal(19,2) DEFAULT NULL,
  `BET_CD_ID_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`APOS_CD_ID_PK`),
  KEY `FK_knppmr53ll4rtr1ycjb8f0dqw` (`BET_CD_ID_FK`),
  CONSTRAINT `FK_knppmr53ll4rtr1ycjb8f0dqw` FOREIGN KEY (`BET_CD_ID_FK`) REFERENCES `bet` (`BET_CD_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aposta
-- ----------------------------

-- ----------------------------
-- Table structure for bandeiras
-- ----------------------------
DROP TABLE IF EXISTS `bandeiras`;
CREATE TABLE `bandeiras` (
  `BAND_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `BAND_DS_COMPETICAO` varchar(255) DEFAULT NULL,
  `BAND_DS_IMAGEM` varchar(255) DEFAULT NULL,
  `BAND_DS_URLIMAGEM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BAND_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bandeiras
-- ----------------------------
INSERT INTO `bandeiras` VALUES ('174', 'Alemanha - 2. Bundesliga', 'Alemanha - 2. Bundesliga.gif', '/resources/images/flags/174.gif');
INSERT INTO `bandeiras` VALUES ('175', 'Alemanha - Bundesliga', 'Alemanha - Bundesliga.gif', '/resources/images/flags/175.gif');
INSERT INTO `bandeiras` VALUES ('176', 'Argentina - Primeira B Nacional', 'Argentina - Primeira B Nacional.gif', '/resources/images/flags/176.gif');
INSERT INTO `bandeiras` VALUES ('177', 'Argentina - Primeira Divisão', 'Argentina - Primeira Divisão.gif', '/resources/images/flags/177.gif');
INSERT INTO `bandeiras` VALUES ('178', 'Brasil - Série A', 'Brasil - Série A.gif', '/resources/images/flags/178.gif');
INSERT INTO `bandeiras` VALUES ('179', 'Brasil - Série B', 'Brasil - Série B.gif', '/resources/images/flags/179.gif');
INSERT INTO `bandeiras` VALUES ('180', 'Bélgica - Primeira Liga', 'Bélgica - Primeira Liga.gif', '/resources/images/flags/180.gif');
INSERT INTO `bandeiras` VALUES ('181', 'China - CSL Super Liga', 'China - CSL Super Liga.gif', '/resources/images/flags/181.gif');
INSERT INTO `bandeiras` VALUES ('182', 'Chipre - Primeira Divisão', 'Chipre - Primeira Divisão.gif', '/resources/images/flags/182.gif');
INSERT INTO `bandeiras` VALUES ('183', 'Coreia do Sul - Primeira Liga', 'Coreia do Sul - Primeira Liga.gif', '/resources/images/flags/183.gif');
INSERT INTO `bandeiras` VALUES ('184', 'Dinamarca - Super Liga', 'Dinamarca - Super Liga.gif', '/resources/images/flags/184.gif');
INSERT INTO `bandeiras` VALUES ('185', 'Escócia - Primeira Liga', 'Escócia - Primeira Liga.gif', '/resources/images/flags/185.gif');
INSERT INTO `bandeiras` VALUES ('186', 'Espanha - Primeira Divisão', 'Espanha - Primeira Divisão.gif', '/resources/images/flags/186.gif');
INSERT INTO `bandeiras` VALUES ('187', 'Espanha - Segunda Divisão', 'Espanha - Segunda Divisão.gif', '/resources/images/flags/187.gif');
INSERT INTO `bandeiras` VALUES ('188', 'Estados Unidos da América - MLS Primeira Liga', 'Estados Unidos da América - MLS Primeira Liga.gif', '/resources/images/flags/188.gif');
INSERT INTO `bandeiras` VALUES ('189', 'França - Ligue 1', 'França - Ligue 1.gif', '/resources/images/flags/189.gif');
INSERT INTO `bandeiras` VALUES ('190', 'França - Ligue 2', 'França - Ligue 2.gif', '/resources/images/flags/190.gif');
INSERT INTO `bandeiras` VALUES ('191', 'Grécia - Segunda Liga', 'Grécia - Segunda Liga.gif', '/resources/images/flags/191.gif');
INSERT INTO `bandeiras` VALUES ('192', 'Grécia - Super Liga', 'Grécia - Super Liga.gif', '/resources/images/flags/192.gif');
INSERT INTO `bandeiras` VALUES ('193', 'Holanda - Eredivisie', 'Holanda - Eredivisie.gif', '/resources/images/flags/193.gif');
INSERT INTO `bandeiras` VALUES ('194', 'Holanda - Segunda Liga', 'Holanda - Segunda Liga.gif', '/resources/images/flags/194.gif');
INSERT INTO `bandeiras` VALUES ('195', 'Hungria - NB I Primeira Liga', 'Hungria - NB I Primeira Liga.gif', '/resources/images/flags/195.gif');
INSERT INTO `bandeiras` VALUES ('196', 'Inglaterra - 2. Championship', 'Inglaterra - 2. Championship.gif', '/resources/images/flags/196.gif');
INSERT INTO `bandeiras` VALUES ('197', 'Inglaterra - 3. League One', 'Inglaterra - 3. League One.gif', '/resources/images/flags/197.gif');
INSERT INTO `bandeiras` VALUES ('198', 'Inglaterra - Premier League', 'Inglaterra - Premier League.gif', '/resources/images/flags/198.gif');
INSERT INTO `bandeiras` VALUES ('199', 'Irlanda - Primeira Divisão', 'Irlanda - Primeira Divisão.gif', '/resources/images/flags/199.gif');
INSERT INTO `bandeiras` VALUES ('200', 'Itália - Série A', 'Itália - Série A.gif', '/resources/images/flags/200.gif');
INSERT INTO `bandeiras` VALUES ('201', 'Itália - Série B', 'Itália - Série B.gif', '/resources/images/flags/201.gif');
INSERT INTO `bandeiras` VALUES ('202', 'Japão - J1 Primeira Liga', 'Japão - J1 Primeira Liga.gif', '/resources/images/flags/202.gif');
INSERT INTO `bandeiras` VALUES ('203', 'Japão - J2 Segunda Liga', 'Japão - J2 Segunda Liga.gif', '/resources/images/flags/203.gif');
INSERT INTO `bandeiras` VALUES ('204', 'Noruega - Primeira Liga', 'Noruega - Primeira Liga.gif', '/resources/images/flags/204.gif');
INSERT INTO `bandeiras` VALUES ('205', 'Polónia - Primeira Liga', 'Polónia - Primeira Liga.gif', '/resources/images/flags/205.gif');
INSERT INTO `bandeiras` VALUES ('206', 'Portugal - Primeira Liga', 'Portugal - Primeira Liga.gif', '/resources/images/flags/206.gif');
INSERT INTO `bandeiras` VALUES ('207', 'Portugal - Segunda Liga', 'Portugal - Segunda Liga.gif', '/resources/images/flags/207.gif');
INSERT INTO `bandeiras` VALUES ('208', 'República Checa - Primeira Liga', 'República Checa - Primeira Liga.gif', '/resources/images/flags/208.gif');
INSERT INTO `bandeiras` VALUES ('209', 'Roménia - Primeira Liga', 'Roménia - Primeira Liga.gif', '/resources/images/flags/209.gif');
INSERT INTO `bandeiras` VALUES ('210', 'Rússia - FNL Segunda Liga', 'Rússia - FNL Segunda Liga.gif', '/resources/images/flags/210.gif');
INSERT INTO `bandeiras` VALUES ('211', 'Rússia - Primeira Liga', 'Rússia - Primeira Liga.gif', '/resources/images/flags/211.gif');
INSERT INTO `bandeiras` VALUES ('212', 'Suécia - Primeira Liga', 'Suécia - Primeira Liga.gif', '/resources/images/flags/212.gif');
INSERT INTO `bandeiras` VALUES ('213', 'Suíça - Super Liga', 'Suíça - Super Liga.gif', '/resources/images/flags/213.gif');
INSERT INTO `bandeiras` VALUES ('214', 'Turquia - Super Liga', 'Turquia - Super Liga.gif', '/resources/images/flags/214.gif');
INSERT INTO `bandeiras` VALUES ('215', 'Ucrânia - Primeira Liga', 'Ucrânia - Primeira Liga.gif', '/resources/images/flags/215.gif');
INSERT INTO `bandeiras` VALUES ('216', 'Azerbaijão - Premier League', 'Azerbaijão - Premier League.gif', '/resources/images/flags/216.gif');
INSERT INTO `bandeiras` VALUES ('217', 'Bielorrusia - Premier League', 'Bielorrusia - Premier League.jpg', '/resources/images/flags/217.gif');
INSERT INTO `bandeiras` VALUES ('218', 'Bulgária - A PFG Primeira Liga', 'Bulgária - A PFG Primeira Liga.gif', '/resources/images/flags/218.gif');
INSERT INTO `bandeiras` VALUES ('219', 'Bósnia - Premier League', 'Bósnia - Premier League.gif', '/resources/images/flags/219.gif');
INSERT INTO `bandeiras` VALUES ('220', 'Croácia - 1. HNL Primeira Liga', 'Croácia - 1. HNL Primeira Liga.gif', '/resources/images/flags/220.gif');

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
  CONSTRAINT `FK_f3p6wnpve0jlsl30ya2631grh` FOREIGN KEY (`EVEN_CD_ID_FK`) REFERENCES `evento` (`EVEN_CD_ID_PK`),
  CONSTRAINT `FK_6rxfauff7jxdkfmvi4gdqyqat` FOREIGN KEY (`CAMP_CD_ID_FK`) REFERENCES `campeonato` (`CAMP_CD_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bet
-- ----------------------------

-- ----------------------------
-- Table structure for campeonato
-- ----------------------------
DROP TABLE IF EXISTS `campeonato`;
CREATE TABLE `campeonato` (
  `CAMP_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `CAMP_DS_SIGLA` varchar(255) DEFAULT NULL,
  `CAMP_DS_URL_COMPETICAO` varchar(255) DEFAULT NULL,
  `CAMP_DS_FLAG` bigint(20) DEFAULT NULL,
  `CAMP_FL_ACADEMIA` tinyint(1) DEFAULT NULL,
  `CAMP_FL_PROSOCCER` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`CAMP_CD_ID_PK`),
  KEY `FKD581E4D9DDFFDE98` (`CAMP_DS_FLAG`),
  CONSTRAINT `FKD581E4D9DDFFDE98` FOREIGN KEY (`CAMP_DS_FLAG`) REFERENCES `bandeiras` (`BAND_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

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
  `EVEN_NM_ODD` double DEFAULT NULL,
  `EVEN_DS_RESULTADO` varchar(255) DEFAULT NULL,
  `MEAP_CD_ID_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`EVEN_CD_ID_PK`),
  KEY `FK_i1l7vtu49vpc7p5f5eb6sk67e` (`MEAP_CD_ID_FK`),
  CONSTRAINT `FK_i1l7vtu49vpc7p5f5eb6sk67e` FOREIGN KEY (`MEAP_CD_ID_FK`) REFERENCES `mercado_aposta` (`MEAP_CD_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evento
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mercado_aposta
-- ----------------------------
INSERT INTO `mercado_aposta` VALUES ('1', 'Over 2.5 ', '2');
INSERT INTO `mercado_aposta` VALUES ('2', 'Under 2.5', '2');
INSERT INTO `mercado_aposta` VALUES ('3', 'Home Team', '1');
INSERT INTO `mercado_aposta` VALUES ('4', 'Draw', '1');
INSERT INTO `mercado_aposta` VALUES ('5', 'Away Team', '1');

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
INSERT INTO `mercado_aposta_selecao` VALUES ('1', 'Resultado FInal');
INSERT INTO `mercado_aposta_selecao` VALUES ('2', 'Gols');
INSERT INTO `mercado_aposta_selecao` VALUES ('3', 'Hipótese Dupla');
