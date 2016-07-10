DELIMITER $$
USE `gwdb`$$

DROP FUNCTION IF EXISTS `create_numeric_column`;

CREATE FUNCTION `create_numeric_column` (
    p_column_name varchar(30),
    p_precision int,
    p_scale int,
    p_nullable bool,
    p_default_value NUMERIC(15, 7)
)
RETURNS TEXT
BEGIN
    DECLARE l_sql TEXT;

    SET @l_sql := concat(upper(p_column_name), ' numeric');
    
    IF p_precision IS NOT NULL AND p_scale IS NULL THEN 
        SET @l_sql := concat(@l_sql, '(', p_precision, ')');
    ELSEIF p_precision IS NOT NULL AND p_scale IS NOT NULL THEN 
        SET @l_sql := concat(@l_sql, '(', p_precision, ', ', p_scale, ')');
    END IF;

    IF p_nullable IS NOT NULL AND p_nullable = 1 THEN
        SET @l_sql := concat(@l_sql, ' not null');
    END IF;

    IF p_default_value IS NOT NULL THEN
        SET @l_sql := concat(@l_sql, ' default ', p_default_value);
    END IF;
    
    RETURN @l_sql;
END$$

DELIMITER ;