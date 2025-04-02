-- V1__Create_task_table.sql
CREATE TABLE task (
  id UUID PRIMARY KEY,
  title VARCHAR(255),
  description TEXT,
  is_completed BOOLEAN,
  due_date TIMESTAMP,
  completed_at TIMESTAMP,
  created_by VARCHAR(255),
  created_at TIMESTAMP,
  CONSTRAINT fk_created_by FOREIGN KEY (created_by) REFERENCES user(username)
);