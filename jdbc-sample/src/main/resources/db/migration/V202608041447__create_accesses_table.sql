CREATE TABLE accesses(
    employee_id BIGINT NOT NULL,
    module_id BIGINT NOT NULL,

    PRIMARY KEY(employee_id, module_id),
    CONSTRAINT fk_acesses_employees FOREIGN KEY (employee_id) REFERENCES employees(id),
    CONSTRAINT fk_acesses_modules FOREIGN KEY (module_id) REFERENCES modules(id)
)engine = INNODB DEFAULT charset = utf8mb4;