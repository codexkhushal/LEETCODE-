# Write your MySQL query statement below
WITH CTE AS (
    SELECT d.name AS Department, e.name AS Employee, e.salary, 
           DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) AS ranking
    FROM Employee e
    JOIN Department d ON e.departmentId = d.id
)
select department , employee , salary 
from CTE
where ranking <= 3;