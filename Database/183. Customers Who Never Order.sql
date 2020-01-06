/* Write your T-SQL query statement below */
select Name as Customers
from Customers
left join Orders
on Customers.Id = Orders.CustomerId
where Orders.Id is null