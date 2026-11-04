select  car_id,
case WHEN MAX('2022-10-16' BETWEEN START_DATE AND END_DATE) = 1
then '대여중'
else '대여 가능'
end as availability
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
group by car_id
order by car_id desc;