CREATE TABLE modules(
    id BIGINT not null auto_increment,
    name VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
)engine = INNODB DEFAULT charset = utf8mb4;