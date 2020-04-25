/* Write your T-SQL query statement below */
select round(count(table2.customer_id)/1.0/count(table1.customer_id)*100, 2) as immediate_percentage
from 
(
    select customer_id, min(order_date) as order_date
    from Delivery
    group by customer_id
) as table1
left join
(
    select customer_id, order_date
    from Delivery
    where order_date = customer_pref_delivery_date
) as table2
on table2.customer_id = table1.customer_id and table2.order_date = table1.order_date