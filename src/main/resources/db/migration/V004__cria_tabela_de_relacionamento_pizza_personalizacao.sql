CREATE TABLE pizza_personalizacao(
	pzps_pizza_id BIGINT(19) NOT NULL,
	pzps_personalizacao_id BIGINT(19) NOT NULL,
	PRIMARY KEY (pzps_pizza_id, pzps_personalizacao_id),
	CONSTRAINT pizza_id_fk FOREIGN KEY (pzps_pizza_id) REFERENCES pizza(pzza_id) ON  DELETE CASCADE,
	CONSTRAINT personalizacao_id_fk FOREIGN KEY (pzps_personalizacao_id) REFERENCES personalizacao(psnl_id) ON  DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;