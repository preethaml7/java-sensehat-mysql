use test_gtfs;

Drop table if exists sensehat;

CREATE TABLE `sensehat` (
    id INT(20) NOT NULL AUTO_INCREMENT,
    collection_date TIMESTAMP NOT NULL,
    temperature DOUBLE(7 , 4 ) NOT NULL,
    humidity DOUBLE(7 , 4 ) NOT NULL,
    pressure DOUBLE(7 , 4 ) NOT NULL,
    sensehat_responsetime DOUBLE(24 , 12 ) DEFAULT NULL,
    PRIMARY KEY (ID)
);

COMMIT;