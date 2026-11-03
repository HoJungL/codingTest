select MEMBER_ID	,MEMBER_NAME,	GENDER	,DATE_OF_BIRTH
from member_profile
where month(date_of_birth) ='03'
and gender ='W'
and tlno is not null
order by member_id;