create database agenciafiscal;
use agenciafiscal
DELIMITER //
CREATE TRIGGER generar_placa
BEFORE INSERT ON placas FOR EACH ROW
BEGIN
    DECLARE letras VARCHAR(3);
    DECLARE numeros VARCHAR(3);
    DECLARE caracteres CHAR(26) DEFAULT 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    DECLARE i INT;

    -- Generar tres letras aleatorias
    SET letras = '';
    SET i = 1;
    WHILE i <= 3 DO
        SET letras = CONCAT(letras, SUBSTRING(caracteres, FLOOR(1 + RAND() * 26), 1));
        SET i = i + 1;
    END WHILE;

    -- Generar tres números aleatorios
    SET numeros = '';
    SET i = 1;
    WHILE i <= 3 DO
        SET numeros = CONCAT(numeros, FLOOR(0 + RAND() * 9));
        SET i = i + 1;
    END WHILE;

    -- Asignar la placa generada al nuevo registro a insertar
    SET NEW.Numero_Placas = CONCAT(letras, '-', numeros);
END;
//
DELIMITER ;