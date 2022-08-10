CREATE TABLE IF NOT EXISTS developers (
    developer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    age INT NOT NULL,
    sex VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS skills (
    skill_id INT AUTO_INCREMENT PRIMARY KEY,
    language VARCHAR(100),
    level VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS projects (
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(100),
    type VARCHAR(100),
    description VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS companies (
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(100),
    residence VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS developers_projects(
developer_id  BIGINT NOT NULL,
project_id  BIGINT NOT NULL,
PRIMARY KEY (developer_id, project_id),
FOREIGN KEY(project_id) REFERENCES projects(project_id),
FOREIGN KEY (developer_id) REFERENCES developers(developer_id)
);

CREATE TABLE IF NOT EXISTS developer_skills(
developer_id  BIGINT NOT NULL,
skill_id  BIGINT NOT NULL,
PRIMARY KEY (developer_id, skill_id),
FOREIGN KEY(skill_id) REFERENCES skills(skill_id),
FOREIGN KEY (developer_id) REFERENCES developers(developer_id)
);

CREATE TABLE IF NOT EXISTS companies_projects(
company_id BIGINT NOT NULL,
project_id  BIGINT NOT NULL,
PRIMARY KEY (company_id, project_id),
FOREIGN KEY(project_id) REFERENCES projects(project_id),
FOREIGN KEY (company_id) REFERENCES companies(company_id)
);

CREATE TABLE IF NOT EXISTS customers_projects(
customer_id  BIGINT NOT NULL,
project_id  BIGINT NOT NULL,
PRIMARY KEY (customer_id, project_id),
FOREIGN KEY(project_id) REFERENCES projects(project_id),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
