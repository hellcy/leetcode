/* Write your T-SQL query statement below */

select Email
from
(
    select Email, count(Email) as count
    from Person
    group by Email
) as table1
where count >= 2

