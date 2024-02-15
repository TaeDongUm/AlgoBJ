-- 코드를 입력하세요
# SELECT U.USER_ID, U.NICKNAME, B.PRICE  AS TOTAL_SALES
# FROM USED_GOODS_BOARD B, USED_GOODS_USER U
# WHERE B.WRITER_ID = U.USER_ID AND B.PRICE >=700000
# ORDER BY B.PRICE ASC;

SELECT u.USER_ID, u.NICKNAME, SUM(b.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD b
JOIN USED_GOODS_USER u ON b.WRITER_ID = u.USER_ID
WHERE b.STATUS = 'DONE'
GROUP BY u.USER_ID
HAVING SUM(b.PRICE) >= 700000
ORDER BY TOTAL_SALES;