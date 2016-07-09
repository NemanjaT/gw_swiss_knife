DELIMITER $$
USE `gwdb`$$

DROP FUNCTION IF EXISTS `create_varchar_column`;

CREATE FUNCTION `create_varchar_column` (
    p_column_name varchar(30),
    p_length int,
    p_nullable bool,
    p_default_value varchar(2000)
)
RETURNS TEXT
BEGIN
    DECLARE l_sql TEXT;

    SET @l_sql := concat(p_column_name, ' varchar(', p_length, ')');

    IF p_nullable IS NOT NULL AND p_nullable = 1 THEN
        SET @l_sql := concat(@l_sql, ' not null');
    END IF;

    IF p_default_value IS NOT NULL THEN
        SET @l_sql := concat(@l_sql, ' default(\'', p_default_value, '\')');
    END IF;

    RETURN @l_sql;
END$$

DELIMITER ;