CREATE TABLE payment (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	payment_id char(36),
	transaction_amount decimal(19,2) NOT NULL ,
	status varchar(255) NOT NULL,
	PRIMARY KEY (id)
	
)
