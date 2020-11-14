USE poolapp;

INSERT IGNORE INTO activities VALUES (1, 'swimming');
INSERT IGNORE INTO activities VALUES (2, 'jumping');
INSERT IGNORE INTO activities VALUES (3, 'diving');

INSERT IGNORE INTO participants VALUES (1, 'Saulius','Germanas', '2020-09-01', '2021-06-01','saulens@gmail.com',
'31005051011');
INSERT IGNORE INTO participants VALUES (2, 'Audrius','Austris', '2020-09-03', '2021-06-01','audrius@gmail.com',
'31005051012');
INSERT IGNORE INTO participants VALUES (3, 'Daina','Dainyte', '2020-09-07', '2021-06-01','daina@gmail.com',
'31005051013');

INSERT IGNORE INTO participant_activities VALUES (1, 1);
INSERT IGNORE INTO participant_activities VALUES (1, 2);
INSERT IGNORE INTO participant_activities VALUES (1, 3);
INSERT IGNORE INTO participant_activities VALUES (1, 4);
INSERT IGNORE INTO participant_activities VALUES (2, 1);
INSERT IGNORE INTO participant_activities VALUES (2, 2);
INSERT IGNORE INTO participant_activities VALUES (2, 3);
INSERT IGNORE INTO participant_activities VALUES (3, 1);
INSERT IGNORE INTO participant_activities VALUES (3, 2);
INSERT IGNORE INTO participant_activities VALUES (3, 3);


