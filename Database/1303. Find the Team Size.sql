/* Write your T-SQL query statement below */
/*
    First calculate the team size for each team using group by
    Then use the original table left join the team size table 
*/
select employee_id, team_size
from Employee
left join 
(
    select team_id, count(employee_id) as team_size
    from Employee
    group by team_id 
) as teams
on Employee.team_id = teams.team_id