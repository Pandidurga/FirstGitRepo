

SELECT e.emp_name,
       Group_concat(p.project_name) AS project_names
FROM   employee AS e
       INNER JOIN employee_project_details AS ep
               ON e.employee_id = ep.employee_id
       INNER JOIN project AS p
               ON p.project_id = ep.project_id
GROUP  BY e.emp_name
HAVING Count(e.employee_id) >= 2; 

OUTPUT:

e_id 	p_id
  A 	X
  A	    Y
  
  

SELECT e.emp_name,
       p.project_name
FROM   employee AS e
       INNER JOIN employee_project_details AS ep
               ON e.employee_id = ep.employee_id
       INNER JOIN project AS p
               ON p.project_id = ep.project_id
WHERE  e.employee_id = (SELECT employee_id
                        FROM   employee_project_details
                        GROUP  BY employee_id
                        HAVING Count(employee_id) > 1); 
						
OUTPUT:
e_id 	p_id

  A 	X,Y
  
SELECT e.emp_name,
       ep.project_id
FROM   employee AS e
       LEFT JOIN employee_project_details AS ep
              ON e.employee_id = ep.employee_id
WHERE  ep.project_id IS NULL; 

OUTPUT:
e_id
  C