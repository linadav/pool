CREATE TABLE IF NOT EXISTS users
(
    id_users       INT PRIMARY KEY AUTO_INCREMENT,
    first_name     VARCHAR(255),
    last_name      VARCHAR(255),
    email          VARCHAR(255),
    id_participant INT
);

CREATE TABLE IF NOT EXISTS participants
(
    id_participant INT PRIMARY KEY AUTO_INCREMENT,
    first_name     VARCHAR(255),
    last_name      VARCHAR(255),
    dateStart      DATE,
    dateStop       DATE,
    email          VARCHAR(255),
    personal_code  VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS attendance
(
    id_attendance  INT PRIMARY KEY AUTO_INCREMENT,
    dateStart      DATE,
    id_participant INT,
    attendance     BOOLEAN
);

CREATE TABLE IF NOT EXISTS activities
(
    id_activity INT PRIMARY KEY AUTO_INCREMENT,
    activity    VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS participant_activities
(
    id_PA          INT PRIMARY KEY AUTO_INCREMENT,
    id_participant INT,
    id_activity    INT
);

CREATE TABLE IF NOT EXISTS payment
(
    id_payment     INT PRIMARY KEY AUTO_INCREMENT,
    dateStart      DATE,
    id_participant INT,
    payment        DOUBLE
);

-- ALTER TABLE users
--     ADD FOREIGN KEY (id_participant) REFERENCES participants (id_participant);
--
-- ALTER TABLE participant_activities
--     ADD FOREIGN KEY (id_participant) REFERENCES participants (id_participant;
--
-- ALTER TABLE participant_activities
--     ADD FOREIGN KEY (id_activity) REFERENCES activities (id_activity);
--
-- ALTER TABLE attendance
--     ADD FOREIGN KEY (id_participant) REFERENCES participants (id_);
--
-- ALTER TABLE payment
--     ADD FOREIGN KEY (id_participant) REFERENCES participants (id);
