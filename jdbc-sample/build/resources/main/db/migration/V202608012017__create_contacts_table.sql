CREATE TABLE contacts(
      id BIGINT not null auto_increment,
      description VARCHAR(50) not null,
      type VARCHAR(30),
      employee_id BIGINT not null,
      PRIMARY KEY(id),
      CONSTRAINT pk_employee_id FOREIGN KEY (employee_id) REFERENCES BootcampJava.employees(id)
)engine=InnoDB default charset=utf8mb4;