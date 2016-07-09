DELIMITER $$
USE `gwdb`$$

DROP PROCEDURE IF EXISTS `create_or_replace_table`$$

CREATE PROCEDURE `create_or_replace_table`(
    p_table_name VARCHAR(30),
    p_acronym VARCHAR(8),
    p_track_update BOOL,
    p_table_body TEXT
)
BEGIN
    DECLARE l_create_sql TEXT;
    DECLARE l_drop_sql TEXT;

    SET @l_create_sql := concat('create table `', upper(p_table_name), '`(ID int primary key auto_increment, ', p_table_body);
    IF (p_track_update = 1) THEN
        SET @l_create_sql := concat(@l_create_sql, ', DC DATETIME, UC varchar(30), DM DATETIME, UM varchar(30)');
    END IF;
    SET @l_create_sql := concat(@l_create_sql, ', STATUS int default 1)');

    SET @l_drop_sql := concat('drop table if exists ', upper(p_table_name));

    PREPARE stmt1 FROM @l_drop_sql;
    EXECUTE stmt1;
    DEALLOCATE PREPARE stmt1;

    PREPARE stmt2 FROM @l_create_sql;
    EXECUTE stmt2;
    DEALLOCATE PREPARE stmt2;

    -- SELECT @l_create_sql;
END$$

DELIMITER ;