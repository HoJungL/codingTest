-- 코드를 입력하세요
SELECT ugb.WRITER_ID as user_id, ugu.nickname as nickname, sum(ugb.price) as total_sales
from used_goods_board as ugb
join used_goods_user as ugu
on ugb.writer_id = ugu.user_id
where ugb.status = 'DONE' 
group by ugb.writer_id
having (sum(ugb.price) >= 700000)
order by total_sales