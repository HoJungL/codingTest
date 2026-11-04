-- 코드를 입력하세요
SELECT ii.INGREDIENT_TYPE, sum(fh.total_order) as TOTAL_ORDER
from FIRST_HALF as fh
join ICECREAM_INFO as ii on ii.flavor = fh.flavor
group by ii.INGREDIENT_TYPE
order by total_order 