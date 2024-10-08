set search_path to car_management;

CREATE TABLE T_RESERVATION
(
    ID              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    CAR_ID          UUID NOT NULL,
    PICK_UP         TIMESTAMP WITH TIME ZONE NOT NULL,
    DROP_OFF        TIMESTAMP WITH TIME ZONE NOT NULL,
    RESERVE_NAME    VARCHAR(255) NOT NULL,
    CONTACT         VARCHAR(20) NOT NULL,
    LICENSE         VARCHAR(20) NOT NULL,
    CONSTRAINT fk_reservation_car
        FOREIGN KEY(CAR_ID)
            REFERENCES T_CAR(ID)
);