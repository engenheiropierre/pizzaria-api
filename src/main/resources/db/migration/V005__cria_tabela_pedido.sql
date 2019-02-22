CREATE TABLE pedido(
	pddo_id BIGINT(19) PRIMARY KEY AUTO_INCREMENT,
	pddo_pizza_id BIGINT(19) NOT NULL,
	pddo_valor_total DECIMAL(9,5) NOT NULL,
	pddo_tempo_preparo INT NOT NULL DEFAULT 0,
	CONSTRAINT pizza_pedido_fk FOREIGN KEY (pddo_pizza_id) REFERENCES pizza(pzza_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;