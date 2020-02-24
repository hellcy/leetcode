/* Write your T-SQL query statement below */

select class
from 
(select count(distinct student) as c, class
from courses
group by class) as temp
where c >= 5

