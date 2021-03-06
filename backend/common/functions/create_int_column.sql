DELIMITER $$
USE `gwdb`$$

DROP FUNCTION IF EXISTS `create_int_column`;

CREATE FUNCTION `create_int_column` (
    p_column_name varchar(30),
    p_nullable bool,
    p_default_value int
)
RETURNS TEXT
BEGIN
    DECLARE l_sql TEXT;

    SET @l_sql := concat(upper(p_column_name), ' int');

    IF p_nullable IS NOT NULL AND p_nullable = 1 THEN
        SET @l_sql := concat(@l_sql, ' not null');
    END IF;

    IF p_default_value IS NOT NULL THEN
        SET @l_sql := concat(@l_sql, ' default ', p_default_value);
    END IF;
    
    RETURN @l_sql;
END$$

DELIMITER ;