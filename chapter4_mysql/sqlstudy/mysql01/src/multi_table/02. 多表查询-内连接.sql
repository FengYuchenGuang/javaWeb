-- ============================= 内连接 ==========================

-- A. 查询员工的姓名 , 及所属的部门名称 (隐式内连接实现)
select tb_emp.name, tb_dept.name
    from tb_emp,
         tb_dept
    where tb_emp.dept_id = tb_dept.id;

-- 起别名
select e.name, d.name
    from tb_emp e,
         tb_dept d
    where e.dept_id = d.id;

-- B. 查询员工的姓名 , 及所属的部门名称 (显式内连接实现)
select tb_emp.name, tb_dept.name
    from tb_emp
        join tb_dept
    on tb_emp.dept_id = tb_dept.id;




