set search_path to car_management;

CREATE TABLE T_CAR
(
    ID          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    BRAND        VARCHAR(50)    NOT NULL,
    MODEL        VARCHAR(50)    NOT NULL,
    ENGINE_TYPE  VARCHAR(10)    NOT NULL,
    CREATED_AT  TIMESTAMP WITH TIME ZONE NOT NULL,
    CREATED_BY  VARCHAR(20)
);