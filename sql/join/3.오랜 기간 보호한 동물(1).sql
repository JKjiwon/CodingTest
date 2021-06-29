SELECT I.NAME NAME, I.DATETIME DATETIME
FROM ANIMAL_INS I
    LEFT JOIN ANIMAL_OUTS O
        USING (ANIMAL_ID)
WHERE O.ANIMAL_ID IS NULL
ORDER BY I.DATETIME
LIMIT 0, 3;