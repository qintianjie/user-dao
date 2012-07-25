-- Export mysql schema
mysqldump colorcc -uroot -p > colorcc.sql

-- Import mysql schema
mysql -h localhost -u root -p colorcc < /opt/backup/sqlscripts/colorcc.sql

-- Some useful scripts

-- Export schema except data.
mysqldump -opt-d database_name -u root-p>xxx.sql

-- Export data except schema.
mysqldump-t database_name -uroot-p>xxx.sql

-- Export database.table's schema.
mysqldump -uroot-p-B database_name -table table_name>xxx.sql