
ALTER TABLE test.employees_audit ADD employee_id BIGINT NOT NULL;
ALTER TABLE test.employees_audit CHANGE employee_id employee_id BIGINT NOT NULL FIRST;
