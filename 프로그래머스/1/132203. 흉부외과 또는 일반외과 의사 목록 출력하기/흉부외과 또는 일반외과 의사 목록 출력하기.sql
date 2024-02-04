# Oracle에서는 to_char, Mysql에서는 date_format

SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD in ('CS','GS')
ORDER BY HIRE_YMD DESC, DR_NAME;

# SELECT DR_NAME, DR_ID, MCDP_CD, TO_CHAR(HIRE_YMD, 'YYYY-MM-DD') AS HIRE_YMD 
# FROM DOCTOR 
# WHERE MCDP_CD IN ('CS', 'GS') 
# ORDER BY HIRE_YMD DESC, DR_NAME ASC;

# SELECT DR_NAME, DR_ID, MCDP_CD, HIRE_YMD
# FROM DOCTOR
# WHERE MCDP_CD IN ('CS', 'GS')
# ORDER BY HIRE_YMD DESC, DR_NAME

# SELECT DR_NAME, DR_ID, MCDP_CD, to_char(HIRE_YMD, 'YYYY-MM-DD') as HIRE_YMD
# FROM DOCTOR 
# WHERE MCDP_CD IN ('CS', 'GS')
# ORDER BY HIRE_YMD DESC, DR_NAME;