select fh.flavor
from first_half as fh
join icecream_info as ii on fh.flavor =ii.flavor
where fh.total_order >3000 and ii.ingredient_type = 'fruit_based'