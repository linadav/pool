CREATE TABLE IF NOT EXISTS users
(
    iduser    INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(255),
    lastname  VARCHAR(255),
    email     VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS participants
(
    idparticipant INT PRIMARY KEY AUTO_INCREMENT,
    firstname     VARCHAR(255),
    lastname      VARCHAR(255),
    datestart     DATE,
    datestop      DATE,
    email         VARCHAR(255),
    personalcode  VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS attendance
(
    idattendance  INT PRIMARY KEY AUTO_INCREMENT,
    datestart     DATE,
    idparticipant INT,
    attendance    BOOLEAN
);

CREATE TABLE IF NOT EXISTS activities
(
    idactivity   INT PRIMARY KEY AUTO_INCREMENT,
    activityname VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS participant_activities
(
    idparticipant INT,
    idactivity    INT
);

CREATE TABLE IF NOT EXISTS payment
(
    idpayment     INT PRIMARY KEY AUTO_INCREMENT,
    datestart     DATE,
    idparticipant INT,
    payment       DOUBLE
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
