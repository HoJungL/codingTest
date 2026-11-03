select child.ITEM_ID	,child.ITEM_NAME	,child.RARITY
from item_info as ii
join item_tree as it on ii.item_id =it.PARENT_ITEM_ID
join item_info as child on it.item_id = child.item_id
where ii.rarity = 'RARE'
order by child.item_id desc