CREATE TABLE sabor(
	sbor_id BIGINT(19) PRIMARY KEY AUTO_INCREMENT,
	sbor_nome VARCHAR(30) NOT NULL,
	sbor_tempo_preparo INT NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO sabor VALUES(DEFAULT, 'Calabresa', 0),
						(DEFAULT, 'Marguerita', 0),
						(DEFAULT, 'Portuguesa', 5);