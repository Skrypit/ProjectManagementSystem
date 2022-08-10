--Creating tables
CREATE TABLE developers (
    developer_id IDENTITY PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    age INT, 
    sex VARCHAR(10)
);

CREATE TABLE skills (
    skill_id IDENTITY PRIMARY KEY,
    language VARCHAR(100),
    level VARCHAR(100)
);

CREATE TABLE projects (
    project_id IDENTITY PRIMARY KEY,
    project_name VARCHAR(100),
    type VARCHAR(100),
    description VARCHAR(100)
);

CREATE TABLE companies (
    company_id IDENTITY PRIMARY KEY,
    company_name VARCHAR(100),
    residence VARCHAR(100)
);

CREATE TABLE customers (
    customer_id IDENTITY PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100)
);

--Creating relationships between tables
CREATE TABLE developers_projects(
developer_id  BIGINT NOT NULL,
project_id  BIGINT NOT NULL,
PRIMARY KEY (developer_id, project_id),
FOREIGN KEY(project_id) REFERENCES projects(project_id),
FOREIGN KEY (developer_id) REFERENCES developers(developer_id)
);

CREATE TABLE developer_skills(
developer_id  BIGINT NOT NULL,
skill_id  BIGINT NOT NULL,
PRIMARY KEY (developer_id, skill_id),
FOREIGN KEY(skill_id) REFERENCES skills(skill_id),
FOREIGN KEY (developer_id) REFERENCES developers(developer_id)
);

CREATE TABLE companies_projects(
company_id BIGINT NOT NULL,
project_id  BIGINT NOT NULL,
PRIMARY KEY (company_id, project_id),
FOREIGN KEY(project_id) REFERENCES projects(project_id),
FOREIGN KEY (company_id) REFERENCES companies(company_id)
);

CREATE TABLE  customers_projects(
customer_id  BIGINT NOT NULL,
project_id  BIGINT NOT NULL,
PRIMARY KEY (customer_id, project_id),
FOREIGN KEY(project_id) REFERENCES projects(project_id),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
