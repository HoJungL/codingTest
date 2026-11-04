-- 코드를 입력하세요
SELECT mcdp_cd as 진료과코드, count(mcdp_cd) as 5월예약건수
from appointment
where APNT_YMD >='2022-05-01' and APNT_YMD <'2022-06-01'
group by mcdp_cd
order by 5월예약건수,진료과코드