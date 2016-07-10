DELIMITER $$
USE `gwdb`$$

DROP FUNCTION IF EXISTS `create_datetime_column`;

CREATE FUNCTION `create_datetime_column` (
    p_column_name varchar(30),
    p_nullable bool,
    p_default_now bool
)
RETURNS TEXT
BEGIN
    DECLARE l_sql TEXT;

    SET @l_sql := concat(upper(p_column_name), ' datetime');

    IF p_nullable IS NOT NULL AND p_nullable = 1 THEN
        SET @l_sql := concat(@l_sql, ' not null');
    END IF;

    IF p_default_now IS NOT NULL AND p_default_now = 1 THEN
        SET @l_sql := concat(@l_sql, ' default current_timestamp');
    END IF;

    RETURN @l_sql;
END$$

DELIMITER ;