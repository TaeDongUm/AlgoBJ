-- 코드를 입력하세요
# SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, BS.SALES
# FROM BOOK B, AUTHOR A, BOOK_SALES BS
# WHERE YEAR(BS.SALES_DATE) ='2022' AND MONTH(BS.SALES_DATE) = '01'

# SELECT AUTHOR_ID, A.AUTHOR_NAME, CATEGORY, SALES
# FROM
#     (
#         SELECT AUTHOR_ID, CATEGORY, (BS.SALES*B.PRICE) AS TOTAL_SALES
#         FROM BOOK B, BOOK_SALES BS
#         WHERE B.BOOK_ID = BS.BOOK_ID
#         GROUP BY AUTHOR_ID, CATEGORY
#     ) AS A JOIN BOOK ON A.BOOD_ID = BOOK.BOOK_ID USING(AUTHOR_ID, CATEGORY)
#     ORDER BY AUTHOR_ID, CATEGORY DESC;
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY,SUM(s.sales * b.price) TOTAL_SALES
from book_sales s join book b on s.book_id=b.book_id
join AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
where date_format(s.sales_date,"%Y-%m")="2022-01"
group by a.author_name, b.category
order by a.author_id, b.category desc