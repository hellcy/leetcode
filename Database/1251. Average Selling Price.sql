/* Write your T-SQL query statement below */
select Prices.product_id, round(sum(price * units) / 1.0 / sum(units), 2) as average_price from
Prices 
left join UnitsSold
on Prices.product_id = UnitsSold.product_id and purchase_date between start_date and end_date
group by Prices.product_id
