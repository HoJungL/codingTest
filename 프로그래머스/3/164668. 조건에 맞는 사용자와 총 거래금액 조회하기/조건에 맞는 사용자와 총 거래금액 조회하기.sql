-- 코드를 입력하세요
SELECT ugu.USER_ID as USER_ID, ugu.nickname as NICKNAME, sum(ugb.PRICE) as TOTAL_SALES
from used_goods_board as ugb
join used_goods_user as ugu
on ugb.writer_id = ugu.user_id
where ugb.status = 'DONE'
group by ugu.user_id,ugu.nickname
having sum(ugb.price) >= 700000
order by TOTAL_SALES
