/* Write your T-SQL query statement below */
with temp as (
    select actor_id, director_id, count(timestamp) as times
    from ActorDirector
    group by actor_id, director_id
)
select actor_id, director_id
from temp
where times >= 3
