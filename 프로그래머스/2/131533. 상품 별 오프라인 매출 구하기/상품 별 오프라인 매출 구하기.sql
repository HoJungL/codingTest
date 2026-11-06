-- 코드를 입력하세요
SELECT p.product_code, (sum(os.sales_amount) * p.price) as sales
from product as p
join offline_sale as os
on p.product_id = os.product_id
group by p.product_code
order by sales desc, p.product_code 
