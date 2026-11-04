select 
    year(e.DIFFERENTIATION_DATE) as year,
    m.max_size - e.size_of_colony as year_dev,
    e.id
from ecoli_data as e
join(


SELECT
    YEAR(DIFFERENTIATION_DATE) AS YEAR,
    MAX(SIZE_OF_COLONY) AS MAX_SIZE
FROM ECOLI_DATA
GROUP BY YEAR(DIFFERENTIATION_DATE)) as m
on year(e.differentiation_date) = m.YEAR
order by year , year_dev 