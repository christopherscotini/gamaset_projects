/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : diaryboard

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-02-19 16:57:05
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
  `TIPS_CD_ID_FK` bigint(20) DEFAULT NULL,
  `PLJI_CD_ID_FK` bigint(20) NOT NULL,
  PRIMARY KEY (`APOS_CD_ID_PK`),
  UNIQUE KEY `UK_fap55olwleejj1se3lq1qqeta` (`APOS_CD_ID_TICKET`),
  KEY `FK_knppmr53ll4rtr1ycjb8f0dqw` (`BET_CD_ID_FK`),
  KEY `FK_htmftqag1t0iub80cdyrt1y2` (`TIPS_CD_ID_FK`),
  KEY `FK_h8yd2yr3s604gglcgmhuoxpws` (`PLJI_CD_ID_FK`),
  CONSTRAINT `FK_h8yd2yr3s604gglcgmhuoxpws` FOREIGN KEY (`PLJI_CD_ID_FK`) REFERENCES `plano_jogo_item` (`PLJI_CD_ID_PK`),
  CONSTRAINT `FK_htmftqag1t0iub80cdyrt1y2` FOREIGN KEY (`TIPS_CD_ID_FK`) REFERENCES `tipster` (`TIPS_CD_ID_PK`),
  CONSTRAINT `FK_knppmr53ll4rtr1ycjb8f0dqw` FOREIGN KEY (`BET_CD_ID_FK`) REFERENCES `bet` (`BET_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aposta
-- ----------------------------
INSERT INTO `aposta` VALUES ('1', '2015-02-05 22:00:00', 'GANHOU', '\0', '1423763782791', '100.00', '288.00', '1', '2', '91');
INSERT INTO `aposta` VALUES ('2', '2015-02-06 22:00:00', 'GANHOU', '\0', '1423766767201', '100.00', '167.00', '2', '1', '91');
INSERT INTO `aposta` VALUES ('3', '2015-02-06 22:00:00', 'GANHOU', '\0', '1423768032625', '100.00', '170.00', '3', '2', '91');
INSERT INTO `aposta` VALUES ('4', '2015-02-06 22:00:00', 'GANHOU', '\0', '1423768084626', '100.00', '144.00', '4', '2', '91');
INSERT INTO `aposta` VALUES ('5', '2015-02-06 22:00:00', 'PERDEU', '\0', '1423768132202', '100.00', '238.00', '5', '2', '91');
INSERT INTO `aposta` VALUES ('6', '2015-02-06 22:00:00', 'PERDEU', '\0', '1423768182530', '100.00', '157.00', '6', '2', '91');
INSERT INTO `aposta` VALUES ('7', '2015-02-06 22:00:00', 'GANHOU', '\0', '1423768228547', '100.00', '190.00', '7', '2', '91');
INSERT INTO `aposta` VALUES ('8', '2015-02-06 22:00:00', 'PERDEU', '\0', '1423768309718', '100.00', '195.00', '8', '2', '91');
INSERT INTO `aposta` VALUES ('9', '2015-02-06 22:00:00', 'GANHOU', '\0', '1423768395104', '100.00', '167.00', '9', '1', '91');
INSERT INTO `aposta` VALUES ('10', '2015-02-06 22:00:00', 'PERDEU', '\0', '1423768462547', '100.00', '238.00', '10', '1', '91');
INSERT INTO `aposta` VALUES ('11', '2015-02-06 22:00:00', 'GANHOU', '\0', '1423768495411', '100.00', '167.00', '11', '1', '91');
INSERT INTO `aposta` VALUES ('12', '2015-02-06 22:00:00', 'PERDEU', '\0', '1423768531047', '100.00', '144.00', '12', '2', '91');
INSERT INTO `aposta` VALUES ('13', '2015-02-06 22:00:00', 'GANHOU', '\0', '1423768567387', '100.00', '150.00', '13', '1', '91');
INSERT INTO `aposta` VALUES ('14', '2015-02-09 22:00:00', 'GANHOU', '\0', '1423768627801', '100.00', '153.00', '14', '1', '91');
INSERT INTO `aposta` VALUES ('15', '2015-02-09 22:00:00', 'GANHOU', '\0', '1423768696306', '100.00', '191.00', '15', '2', '91');
INSERT INTO `aposta` VALUES ('16', '2015-02-09 22:00:00', 'GANHOU', '\0', '1423768733621', '100.00', '170.00', '16', '1', '91');
INSERT INTO `aposta` VALUES ('17', '2015-02-10 22:00:00', 'GANHOU', '\0', '1423768773391', '100.00', '208.00', '17', '1', '91');
INSERT INTO `aposta` VALUES ('18', '2015-02-10 22:00:00', 'GANHOU', '\0', '1423768803908', '100.00', '167.00', '18', '2', '91');

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
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bet
-- ----------------------------
INSERT INTO `bet` VALUES ('1', '15', '1');
INSERT INTO `bet` VALUES ('2', '17', '2');
INSERT INTO `bet` VALUES ('3', '16', '3');
INSERT INTO `bet` VALUES ('4', '16', '4');
INSERT INTO `bet` VALUES ('5', '16', '5');
INSERT INTO `bet` VALUES ('6', '16', '6');
INSERT INTO `bet` VALUES ('7', '16', '7');
INSERT INTO `bet` VALUES ('8', '16', '8');
INSERT INTO `bet` VALUES ('9', '17', '9');
INSERT INTO `bet` VALUES ('10', '17', '10');
INSERT INTO `bet` VALUES ('11', '17', '11');
INSERT INTO `bet` VALUES ('12', '15', '12');
INSERT INTO `bet` VALUES ('13', '15', '13');
INSERT INTO `bet` VALUES ('14', '15', '14');
INSERT INTO `bet` VALUES ('15', '16', '15');
INSERT INTO `bet` VALUES ('16', '16', '16');
INSERT INTO `bet` VALUES ('17', '16', '17');
INSERT INTO `bet` VALUES ('18', '16', '18');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evento
-- ----------------------------
INSERT INTO `evento` VALUES ('1', null, 'SCHALKE 04', 'MONCHENGLADBACH', 'SCHALKE 04 vs MONCHENGLADBACH', '2.88', '1');
INSERT INTO `evento` VALUES ('2', null, 'RENNES', 'MARSEILLE', 'RENNES vs MARSEILLE', '1.67', '2');
INSERT INTO `evento` VALUES ('3', null, 'TOTTENHAM', 'ARSENAL', 'TOTTENHAM vs ARSENAL', '1.70', '1');
INSERT INTO `evento` VALUES ('4', null, 'ASTON VILLA', 'CHELSEA', 'ASTON VILLA vs CHELSEA', '1.44', '5');
INSERT INTO `evento` VALUES ('5', null, 'EVERTON', 'LIVERPOOL', 'EVERTON vs LIVERPOOL', '2.38', '1');
INSERT INTO `evento` VALUES ('6', null, 'MANCHESTER CITY', 'HULL', 'MANCHESTER CITY vs HULL', '1.57', '1');
INSERT INTO `evento` VALUES ('7', null, 'QUEENS PARK', 'SOUTHAMPTON', 'QUEENS PARK vs SOUTHAMPTON', '1.90', '5');
INSERT INTO `evento` VALUES ('8', null, 'SWANSEA', 'SUNDERLAND', 'SWANSEA vs SUNDERLAND', '1.95', '3');
INSERT INTO `evento` VALUES ('9', null, 'RENNES', 'MARSEILLE', 'RENNES vs MARSEILLE', '1.67', '2');
INSERT INTO `evento` VALUES ('10', null, 'MONTPELLIER', 'LILLE', 'MONTPELLIER vs LILLE', '2.38', '3');
INSERT INTO `evento` VALUES ('11', null, 'CAEN', 'TOULOUSE', 'CAEN vs TOULOUSE', '1.67', '2');
INSERT INTO `evento` VALUES ('12', null, 'STUTTGART', 'BAYERN MUNCHEN', 'STUTTGART vs BAYERN MUNCHEN', '1.44', '1');
INSERT INTO `evento` VALUES ('13', null, 'WOLFSBURG', 'HOFFENHEIM', 'WOLFSBURG vs HOFFENHEIM', '1.50', '3');
INSERT INTO `evento` VALUES ('14', null, 'ARSENAL', 'LEICESTER', 'ARSENAL vs LEICESTER', '1.53', '1');
INSERT INTO `evento` VALUES ('15', null, 'LIVERPOOL', 'TOTTENHAM', 'LIVERPOOL vs TOTTENHAM', '1.91', '3');
INSERT INTO `evento` VALUES ('16', null, 'LIVERPOOL', 'TOTTENHAM', 'LIVERPOOL vs TOTTENHAM', '1.70', '1');
INSERT INTO `evento` VALUES ('17', null, 'CHELSEA', 'EVERTON', 'CHELSEA vs EVERTON', '2.08', '2');
INSERT INTO `evento` VALUES ('18', null, 'STOKE', 'MANCHESTER CITY', 'STOKE vs MANCHESTER CITY', '1.67', '5');

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
INSERT INTO `mercado_aposta_selecao` VALUES ('1', 'Resultado Final');
INSERT INTO `mercado_aposta_selecao` VALUES ('2', 'Gols');
INSERT INTO `mercado_aposta_selecao` VALUES ('3', 'Hipótese Dupla');

-- ----------------------------
-- Table structure for plano_jogo
-- ----------------------------
DROP TABLE IF EXISTS `plano_jogo`;
CREATE TABLE `plano_jogo` (
  `PLJO_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `PLJO_DT_CRIACAO` datetime DEFAULT NULL,
  `PLJO_DS_DESCRICAO` varchar(255) DEFAULT NULL,
  `PLJO_NM_DIAS_PLANO` int(11) DEFAULT NULL,
  `PLJO_PC_APOSTA_DIA` decimal(19,2) DEFAULT NULL,
  `PLJO_PC_LUCRO_DIA` decimal(19,2) DEFAULT NULL,
  `PLJO_VL_INVESTIMENTO_INICIAL` decimal(19,2) DEFAULT NULL,
  `PLJO_FL_ATIVO` bit(1) DEFAULT NULL,
  PRIMARY KEY (`PLJO_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plano_jogo
-- ----------------------------
INSERT INTO `plano_jogo` VALUES ('4', '2015-01-31 22:00:00', 'TESTE_1', '30', '20.00', '30.00', '1000.00', '');
INSERT INTO `plano_jogo` VALUES ('5', '2015-01-31 22:00:00', 'TESTE_2', '30', '100.00', '30.00', '10.00', '\0');

-- ----------------------------
-- Table structure for plano_jogo_item
-- ----------------------------
DROP TABLE IF EXISTS `plano_jogo_item`;
CREATE TABLE `plano_jogo_item` (
  `PLJI_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `PLJI_DS_DESCRICAO` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plano_jogo_item
-- ----------------------------
INSERT INTO `plano_jogo_item` VALUES ('91', 'DIA 1', null, null, '76.92', '200.00', '200.00', '1000.00', '1300.00', '1000.00', '1000.00', '0.00', '300.00', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('92', 'DIA 2', null, null, '59.17', '260.00', '260.00', '1000.00', '1690.00', '1000.00', '1300.00', '0.00', '390.00', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('93', 'DIA 3', null, null, '45.52', '338.00', '338.00', '1000.00', '2197.00', '1000.00', '1690.00', '0.00', '507.00', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('94', 'DIA 4', null, null, '35.01', '439.40', '439.40', '1000.00', '2856.10', '1000.00', '2197.00', '0.00', '659.10', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('95', 'DIA 5', null, null, '26.93', '571.22', '571.22', '1000.00', '3712.93', '1000.00', '2856.10', '0.00', '856.83', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('96', 'DIA 6', null, null, '20.72', '742.59', '742.59', '1000.00', '4826.81', '1000.00', '3712.93', '0.00', '1113.88', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('97', 'DIA 7', null, null, '15.94', '965.36', '965.36', '1000.00', '6274.85', '1000.00', '4826.81', '0.00', '1448.04', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('98', 'DIA 8', null, null, '12.26', '1254.97', '1254.97', '1000.00', '8157.31', '1000.00', '6274.85', '0.00', '1882.46', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('99', 'DIA 9', null, null, '9.43', '1631.46', '1631.46', '1000.00', '10604.50', '1000.00', '8157.31', '0.00', '2447.19', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('100', 'DIA 10', null, null, '7.25', '2120.90', '2120.90', '1000.00', '13785.85', '1000.00', '10604.50', '0.00', '3181.35', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('101', 'DIA 11', null, null, '5.58', '2757.17', '2757.17', '1000.00', '17921.61', '1000.00', '13785.85', '0.00', '4135.76', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('102', 'DIA 12', null, null, '4.29', '3584.32', '3584.32', '1000.00', '23298.09', '1000.00', '17921.61', '0.00', '5376.48', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('103', 'DIA 13', null, null, '3.30', '4659.62', '4659.62', '1000.00', '30287.52', '1000.00', '23298.09', '0.00', '6989.43', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('104', 'DIA 14', null, null, '2.54', '6057.50', '6057.50', '1000.00', '39373.78', '1000.00', '30287.52', '0.00', '9086.26', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('105', 'DIA 15', null, null, '1.95', '7874.76', '7874.76', '1000.00', '51185.91', '1000.00', '39373.78', '0.00', '11812.13', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('106', 'DIA 16', null, null, '1.50', '10237.18', '10237.18', '1000.00', '66541.68', '1000.00', '51185.91', '0.00', '15355.77', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('107', 'DIA 17', null, null, '1.16', '13308.34', '13308.34', '1000.00', '86504.18', '1000.00', '66541.68', '0.00', '19962.50', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('108', 'DIA 18', null, null, '0.89', '17300.84', '17300.84', '1000.00', '112455.43', '1000.00', '86504.18', '0.00', '25951.25', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('109', 'DIA 19', null, null, '0.68', '22491.09', '22491.09', '1000.00', '146192.06', '1000.00', '112455.43', '0.00', '33736.63', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('110', 'DIA 20', null, null, '0.53', '29238.41', '29238.41', '1000.00', '190049.68', '1000.00', '146192.06', '0.00', '43857.62', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('111', 'DIA 21', null, null, '0.40', '38009.94', '38009.94', '1000.00', '247064.58', '1000.00', '190049.68', '0.00', '57014.90', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('112', 'DIA 22', null, null, '0.31', '49412.92', '49412.92', '1000.00', '321183.95', '1000.00', '247064.58', '0.00', '74119.37', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('113', 'DIA 23', null, null, '0.24', '64236.79', '64236.79', '1000.00', '417539.13', '1000.00', '321183.95', '0.00', '96355.18', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('114', 'DIA 24', null, null, '0.18', '83507.83', '83507.83', '1000.00', '542800.87', '1000.00', '417539.13', '0.00', '125261.74', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('115', 'DIA 25', null, null, '0.14', '108560.17', '108560.17', '1000.00', '705641.13', '1000.00', '542800.87', '0.00', '162840.26', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('116', 'DIA 26', null, null, '0.11', '141128.23', '141128.23', '1000.00', '917333.47', '1000.00', '705641.13', '0.00', '211692.34', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('117', 'DIA 27', null, null, '0.08', '183466.69', '183466.69', '1000.00', '1192533.51', '1000.00', '917333.47', '0.00', '275200.04', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('118', 'DIA 28', null, null, '0.06', '238506.70', '238506.70', '1000.00', '1550293.56', '1000.00', '1192533.51', '0.00', '357760.05', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('119', 'DIA 29', null, null, '0.05', '310058.71', '310058.71', '1000.00', '2015381.63', '1000.00', '1550293.56', '0.00', '465088.07', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('120', 'DIA 30', null, null, '0.04', '403076.33', '403076.33', '1000.00', '2619996.12', '1000.00', '2015381.63', '0.00', '604614.49', null, null, '4');
INSERT INTO `plano_jogo_item` VALUES ('121', 'DIA 1', null, null, '76.92', '10.00', '10.00', '10.00', '13.00', '10.00', '10.00', '0.00', '3.00', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('122', 'DIA 2', null, null, '59.17', '13.00', '13.00', '10.00', '16.90', '10.00', '13.00', '0.00', '3.90', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('123', 'DIA 3', null, null, '45.52', '16.90', '16.90', '10.00', '21.97', '10.00', '16.90', '0.00', '5.07', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('124', 'DIA 4', null, null, '35.01', '21.97', '21.97', '10.00', '28.56', '10.00', '21.97', '0.00', '6.59', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('125', 'DIA 5', null, null, '26.93', '28.56', '28.56', '10.00', '37.13', '10.00', '28.56', '0.00', '8.57', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('126', 'DIA 6', null, null, '20.72', '37.13', '37.13', '10.00', '48.27', '10.00', '37.13', '0.00', '11.14', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('127', 'DIA 7', null, null, '15.94', '48.27', '48.27', '10.00', '62.75', '10.00', '48.27', '0.00', '14.48', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('128', 'DIA 8', null, null, '12.26', '62.75', '62.75', '10.00', '81.57', '10.00', '62.75', '0.00', '18.82', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('129', 'DIA 9', null, null, '9.43', '81.57', '81.57', '10.00', '106.04', '10.00', '81.57', '0.00', '24.47', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('130', 'DIA 10', null, null, '7.25', '106.04', '106.04', '10.00', '137.85', '10.00', '106.04', '0.00', '31.81', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('131', 'DIA 11', null, null, '5.58', '137.85', '137.85', '10.00', '179.21', '10.00', '137.85', '0.00', '41.36', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('132', 'DIA 12', null, null, '4.29', '179.21', '179.21', '10.00', '232.97', '10.00', '179.21', '0.00', '53.76', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('133', 'DIA 13', null, null, '3.30', '232.97', '232.97', '10.00', '302.86', '10.00', '232.97', '0.00', '69.89', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('134', 'DIA 14', null, null, '2.54', '302.86', '302.86', '10.00', '393.72', '10.00', '302.86', '0.00', '90.86', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('135', 'DIA 15', null, null, '1.95', '393.72', '393.72', '10.00', '511.84', '10.00', '393.72', '0.00', '118.12', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('136', 'DIA 16', null, null, '1.50', '511.84', '511.84', '10.00', '665.39', '10.00', '511.84', '0.00', '153.55', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('137', 'DIA 17', null, null, '1.16', '665.39', '665.39', '10.00', '865.01', '10.00', '665.39', '0.00', '199.62', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('138', 'DIA 18', null, null, '0.89', '865.01', '865.01', '10.00', '1124.51', '10.00', '865.01', '0.00', '259.50', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('139', 'DIA 19', null, null, '0.68', '1124.51', '1124.51', '10.00', '1461.86', '10.00', '1124.51', '0.00', '337.35', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('140', 'DIA 20', null, null, '0.53', '1461.86', '1461.86', '10.00', '1900.42', '10.00', '1461.86', '0.00', '438.56', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('141', 'DIA 21', null, null, '0.40', '1900.42', '1900.42', '10.00', '2470.55', '10.00', '1900.42', '0.00', '570.13', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('142', 'DIA 22', null, null, '0.31', '2470.55', '2470.55', '10.00', '3211.71', '10.00', '2470.55', '0.00', '741.16', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('143', 'DIA 23', null, null, '0.24', '3211.71', '3211.71', '10.00', '4175.22', '10.00', '3211.71', '0.00', '963.51', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('144', 'DIA 24', null, null, '0.18', '4175.22', '4175.22', '10.00', '5427.79', '10.00', '4175.22', '0.00', '1252.57', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('145', 'DIA 25', null, null, '0.14', '5427.79', '5427.79', '10.00', '7056.13', '10.00', '5427.79', '0.00', '1628.34', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('146', 'DIA 26', null, null, '0.11', '7056.13', '7056.13', '10.00', '9172.97', '10.00', '7056.13', '0.00', '2116.84', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('147', 'DIA 27', null, null, '0.08', '9172.97', '9172.97', '10.00', '11924.86', '10.00', '9172.97', '0.00', '2751.89', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('148', 'DIA 28', null, null, '0.06', '11924.86', '11924.86', '10.00', '15502.32', '10.00', '11924.86', '0.00', '3577.46', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('149', 'DIA 29', null, null, '0.05', '15502.32', '15502.32', '10.00', '20153.02', '10.00', '15502.32', '0.00', '4650.70', null, null, '5');
INSERT INTO `plano_jogo_item` VALUES ('150', 'DIA 30', null, null, '0.04', '20153.02', '20153.02', '10.00', '26198.93', '10.00', '20153.02', '0.00', '6045.91', null, null, '5');

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
