CREATE TABLE employees_audit(
    id BIGINT not null auto_increment,
    old_name VARCHAR(150),
    name VARCHAR(150),
    salary decimal(10, 2),
    old_salary decimal(10, 2),
    birthday TIMESTAMP,
    old_birthday TIMESTAMP,
    operation CHAR(1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*Salva o momento da operação*/
    PRIMARY KEY (id)
)engine=InnoDB default charset=utf8mb4;