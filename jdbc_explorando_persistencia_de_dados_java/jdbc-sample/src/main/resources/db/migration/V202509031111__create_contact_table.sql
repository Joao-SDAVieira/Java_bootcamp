CREATE TABLE contacts(
    id BIGINT not null auto_increment,
    desciption VARCHAR(50) NOT NULL,
    type VARCHAR(30),
    employee_id BIGINT not null,
    CONSTRAINT fk_contacts FOREIGN KEY (employee_id) REFERENCES employees(id),
    PRIMARY KEY(id)
)