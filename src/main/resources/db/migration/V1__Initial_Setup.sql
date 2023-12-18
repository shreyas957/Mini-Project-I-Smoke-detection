CREATE TABLE sensor_data
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255),
    created_at TIMESTAMP,
    field1     VARCHAR(255)
);
