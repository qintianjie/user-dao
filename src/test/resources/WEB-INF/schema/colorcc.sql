insert USER values (1, 'jack@colorcc.com', 'pwd', 'salt', '2012-05-26', 0);

ALTER TABLE `colorcc`.`ROLE` ADD UNIQUE INDEX `ROLE_UNIQUE` (`ROLE` ASC) ;
ALTER TABLE `colorcc`.`USER_ROLE` CHANGE COLUMN `ID` `ID` BIGINT NOT NULL  ;

INSERT INTO `colorcc`.`ROLE` (`ID`, `ROLE`) VALUES (1, 'USER');
INSERT INTO `colorcc`.`ROLE` (`ID`, `ROLE`) VALUES (2, 'ADMIN');
INSERT INTO `colorcc`.`ROLE` (`ID`, `ROLE`) VALUES (3, 'SUPERUSER');
