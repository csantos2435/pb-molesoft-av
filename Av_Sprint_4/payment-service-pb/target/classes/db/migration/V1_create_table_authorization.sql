CREATE TABLE authorizations (
	id bigInt(20) NOT NULL AUTO_INCREMENT,
	authorized_at datetime NOT NULL,
	reason_code bigInt(20) AUTO_INCREMENT,
	reason_message varchar(255) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (payment_id) REFERENCES payment(id)
)
