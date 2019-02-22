CREATE TABLE personalizacao(
	psnl_id BIGINT(19) PRIMARY KEY AUTO_INCREMENT,
	psnl_nome VARCHAR(30) NOT NULL,
	psnl_valor_adicional DECIMAL(9,5) NOT NULL DEFAULT 0,
	psnl_tempo_preparo_adicional INT NOT NULL DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO personalizacao VALUES(DEFAULT, 'Extra bacon', 3.0, 0),
								 (DEFAULT, 'Sem cebola', 0.0, 0),
								 (DEFAULT, 'Borda recheada', 5.0, 5);