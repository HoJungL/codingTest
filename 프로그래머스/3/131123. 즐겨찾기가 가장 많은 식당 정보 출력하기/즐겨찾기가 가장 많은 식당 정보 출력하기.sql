-- 코드를 입력하세요
select ri.food_type, ri.rest_id, ri.rest_name, ri.favorites
from rest_info as ri
join 
(SELECT food_type, max(favorites) as favorites
from rest_info
group by food_type) as F
on ri.favorites = F.favorites
and ri.food_type = F.food_type
order by ri.food_type desc