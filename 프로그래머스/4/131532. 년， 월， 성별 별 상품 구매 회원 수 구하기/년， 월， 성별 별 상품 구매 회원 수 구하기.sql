-- 코드를 입력하세요
SELECT 
    year(os.SALES_DATE) as year,
    month(os.SALES_DATE) as month,
    ui.gender as gender,
    count(distinct ui.user_id) as users
from user_info as ui
join online_sale as os 
on ui.user_id = os.user_id
where ui.gender is not null 
group by year(sales_date), month(sales_date), ui.gender
order by year(sales_date), month(sales_date), ui.gender