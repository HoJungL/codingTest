-- 코드를 입력하세요
SELECT
    F.CATEGORY,
    F.PRICE AS MAX_PRICE,
    F.PRODUCT_NAME
FROM FOOD_PRODUCT F
join 
(SELECT category, max(price) as max_price
from food_product
where category in ('과자','국','김치','식용유')
group by category) as M
on F.category = M.category
and F.PRICE = M.max_price
order by price desc