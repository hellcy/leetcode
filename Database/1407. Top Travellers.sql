/* Write your T-SQL query statement below */
select name, CASE when SUM(distance) is null then 0 else SUM(distance) end as travelled_distance
from Users
left join Rides
on Users.id = Rides.user_id
group by user_id, name 
order by travelled_distance DESC, name