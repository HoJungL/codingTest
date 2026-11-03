-- 코드를 입력하세요
SELECT 
    ri.rest_id as REST_ID,
    ri.rest_name as REST_NAME,
    ri.food_type as FOOD_TYPE,
    ri.favorites as FAVORITES,
    ri.address as ADDRESS,
    round(avg(rr.REVIEW_SCORE),2) as SCORE
from rest_info as ri
join rest_review as rr on ri.rest_id =rr.rest_id
where address like '서울%'
group by
    ri.rest_id,
    ri.rest_name,
    ri.food_type,
    ri.favorites,
    ri.address
order by SCORE desc, ri.favorites desc