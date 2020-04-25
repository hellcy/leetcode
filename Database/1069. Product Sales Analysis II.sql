/* Write your T-SQL query statement below */
/*
    group by command
*/
Select p.product_id, sum(s.quantity) as total_quantity
From Sales s, Product p
where s.product_id = p.product_id
group by p.product_id