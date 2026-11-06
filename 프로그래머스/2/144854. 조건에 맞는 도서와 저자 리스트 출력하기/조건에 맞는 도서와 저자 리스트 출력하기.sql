-- 코드를 입력하세요
SELECT b.book_id, au.author_name, b.published_date
from book as b
join author as au
on b.author_id = au.author_id
where b.category = '경제'
order by b.published_date;