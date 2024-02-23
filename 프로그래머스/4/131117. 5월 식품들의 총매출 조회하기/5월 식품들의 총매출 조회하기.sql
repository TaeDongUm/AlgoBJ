-- 코드를 입력하세요
WITH TEMP AS (
    SELECT PRODUCT_ID, SUM(AMOUNT) AS AMOUNT
    FROM FOOD_ORDER
    WHERE YEAR(PRODUCE_DATE) ='2022' AND MONTH(PRODUCE_DATE) ='05'  
    GROUP BY PRODUCT_ID

)
SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME, (T.AMOUNT*FP.PRICE) AS TOTAL_SALES
FROM FOOD_PRODUCT FP JOIN TEMP T ON FP.PRODUCT_ID = T.PRODUCT_ID
WHERE FP.PRODUCT_ID IN (
    SELECT PRODUCT_ID
    FROM TEMP
)
ORDER BY (T.AMOUNT*FP.PRICE) DESC, FP.PRODUCT_ID;
