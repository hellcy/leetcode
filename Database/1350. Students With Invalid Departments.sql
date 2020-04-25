/* Write your T-SQL query statement below */
select S.id, S.name
from Students as S
where S.department_id not in (select id from departments)