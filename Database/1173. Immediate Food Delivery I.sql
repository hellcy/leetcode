/* Write your T-SQL query statement below */
select round(count(table1.delivery_id)/1.0/count(Delivery.delivery_id)*100, 2) as immediate_percentage
from Delivery
left join
(
    select delivery_id
    from Delivery
    where order_date = customer_pref_delivery_date
) as table1
on Delivery.delivery_id = table1.delivery_id