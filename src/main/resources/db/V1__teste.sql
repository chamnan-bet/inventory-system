
CREATE TABLE test
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT pk_test PRIMARY KEY (id)
);



ALTER TABLE products
    MODIFY created_at datetime NULL;

ALTER TABLE users
    MODIFY enabled BIT (1) NOT NULL;

ALTER TABLE products
    MODIFY price DECIMAL;

ALTER TABLE stock_transactions
    MODIFY transaction_date datetime NULL;

ALTER TABLE stock_transactions
DROP
COLUMN type;

ALTER TABLE stock_transactions
    ADD type VARCHAR(255) NOT NULL;