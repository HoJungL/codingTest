-- 코드를 입력하세요
SELECT a.author_id, a.author_name, b.category, sum(sales * price) as TOTAL_SALES
from book as b
join book_sales as bs on b.book_id = bs.book_id
join author as a on b.author_id = a.author_id
where bs.sales_date >= '2022-01-01' and bs.sales_date < '2022-02-01'
group by b.author_id, b.category
order by b.author_id, b.category desc