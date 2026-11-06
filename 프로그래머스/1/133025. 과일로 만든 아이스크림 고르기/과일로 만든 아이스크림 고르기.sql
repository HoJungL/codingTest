-- 코드를 입력하세요
SELECT fh.FLAVOR
from first_half as fh
join icecream_info as ii
on fh.flavor = ii.flavor
where ii.INGREDIENT_TYPE = 'fruit_based' and fh.total_order >3000
order by fh.total_order desc