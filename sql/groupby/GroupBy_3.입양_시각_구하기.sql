# WHERE 절을 이용한 풀이
SELECT HOUR(DATETIME) HOUR, COUNT(HOUR(DATETIME)) COUNT
    FROM ANIMAL_OUTS
    WHERE HOUR(DATETIME) >= 9 AND HOUR(DATETIME) <= 19
    GROUP BY HOUR
    ORDER BY HOUR;

/*
WHERE 절에는 SELECT절의 alias를 쓸 수 없다.
근거 : Standard SQL doesn't allow you to refer to a column alias in a WHERE clause.
      This restriction is imposed because when the WHERE code is executed, the column value may not yet be determined.
GROUP BY, ORDER BY 또는 HAVING 절에서만 열 별칭을 사용할 수 있습니다.
*/

# HAVING 절을 이용한 풀이
SELECT HOUR(DATETIME) HOUR, COUNT(HOUR(DATETIME)) COUNT
    FROM ANIMAL_OUTS
    GROUP BY HOUR
    HAVING HOUR >= 9 AND HOUR <= 19
    ORDER BY HOUR;