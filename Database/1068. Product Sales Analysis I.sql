/* Write your T-SQL query statement below */
/*
    select from two tables
*/
Select p.product_name, s.year, s.price
From Sales s, Product p
Where s.product_id = p.product_id