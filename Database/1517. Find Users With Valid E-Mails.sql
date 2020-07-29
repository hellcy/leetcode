/* Write your T-SQL query statement below */
select * from Users
where mail like '[A-Za-z]%@leetcode.com' and PATINDEX('%[^a-z,0-9,.,_,\-]%', left(mail, len(mail)-13)) = 0 