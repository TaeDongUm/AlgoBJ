-- 코드를 입력하세요
WITH TEMP1 AS(
    SELECT CC.CAR_ID, CC.CAR_TYPE, CC.DAILY_FEE
    FROM CAR_RENTAL_COMPANY_CAR CC
    WHERE CC.CAR_TYPE IN ('SUV','세단') AND CC.CAR_ID NOT IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE BETWEEN '2022-11-01' AND '2022-11-30'
OR (END_DATE BETWEEN '2022-11-01' AND '2022-11-30')
OR (START_DATE <= '2022-11-01' AND END_DATE >= '2022-11-30')
    )

), TEMP2 AS (
    SELECT CAR_TYPE, CAST(REPLACE(DISCOUNT_RATE, '%','') AS UNSIGNED) AS DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE CAR_TYPE IN ('SUV', '세단') AND DURATION_TYPE = '30일 이상'
    
)
SELECT T1.CAR_ID, T1.CAR_TYPE, FLOOR(30*(T1.DAILY_FEE-T1.DAILY_FEE*(T2.DISCOUNT_RATE*0.01))) AS FEE
FROM TEMP1 T1 JOIN TEMP2 T2 ON T1.CAR_TYPE = T2.CAR_TYPE
WHERE FLOOR(30*(T1.DAILY_FEE-T1.DAILY_FEE*(T2.DISCOUNT_RATE*0.01)))>= 500000 AND FLOOR(30*(T1.DAILY_FEE-T1.DAILY_FEE*(T2.DISCOUNT_RATE*0.01))) < 2000000
ORDER BY FLOOR(30*(T1.DAILY_FEE-T1.DAILY_FEE*(T2.DISCOUNT_RATE*0.01))) DESC, T1.CAR_TYPE, T1.CAR_ID DESC;

# SELECT *
# FROM TEMP1 T1 JOIN TEMP2 T2 ON T1.CAR_TYPE = T2.CAR_TYPE

# SELECT *
# FROM TEMP1