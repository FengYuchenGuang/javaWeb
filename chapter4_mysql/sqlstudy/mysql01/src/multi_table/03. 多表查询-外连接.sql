-- =============================== 外连接 ============================

-- A. 查询员工表 所有 员工的姓名, 和对应的部门名称 (左外连接)
select e.name, d.name from tb_emp e left join tb_dept d on e.dept_id = d.id;

-- B. 查询部门表 所有 部门的名称, 和对应的员工名称 (右外连接)
select e.name,d.name from tb_emp e right join tb_dept d on e.dept_id = d.id;

select e.name, d.name from tb_dept d left join tb_emp e on e.dept_id = d.id;




