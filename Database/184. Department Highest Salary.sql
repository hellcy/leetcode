/* Write your T-SQL query statement below */
select D.Name as Department, E.Name as Employee, E.Salary as Salary
from Employee as E, Department as D
where D.Id = E.DepartmentID and 
(
    E.Salary = 
    (
        select S from 
        (
           select max(Salary) as S, DepartmentId as Id
            from Employee
            group by DepartmentId 
        ) as temp
        where E.DepartmentId = temp.Id
    )
)