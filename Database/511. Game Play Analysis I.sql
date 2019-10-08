/* Write your T-SQL query statement below */
/*
    Group by and select first record
*/
select player_id, min(event_date) as first_login
from Activity
group by player_id