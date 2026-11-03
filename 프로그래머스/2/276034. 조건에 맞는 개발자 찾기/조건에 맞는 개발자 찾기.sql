SELECT
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
FROM DEVELOPERS
WHERE (SKILL_CODE & (
    select code from skillcodes where name ='Python')) > 0
   OR (SKILL_CODE & (
   select code from skillcodes where name ='C#')) > 0
ORDER BY ID;