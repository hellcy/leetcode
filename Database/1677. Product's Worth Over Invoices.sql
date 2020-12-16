/* Write your T-SQL query statement below */
select a.name, sum(b.rest) as rest, sum(b.paid) as paid, sum(b.canceled) as canceled, sum(b.refunded) as refunded from Product as a inner join Invoice as b
on a.product_id = b.product_id
group by a.name 