-- 코드를 입력하세요
SELECT count(USER_ID) as users
from user_info
where (joined  between "2021-01-01" and "2021-12-31") and 
(age between 20 and 29)