/* 중고거래 게시판*/
select ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, ugr.created_date
from used_goods_board as ugb
join used_goods_reply as ugr on ugb.board_id =ugr.board_id
where ugb.CREATED_DATE >='2022-10-01' and ugb.created_date <'2022-11-01'
order by ugr.created_date, ugb.title

