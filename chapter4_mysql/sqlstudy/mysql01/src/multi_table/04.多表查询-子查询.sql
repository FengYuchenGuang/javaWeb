-- ========================= 子查询 ================================

-- 标量子查询
-- A. 查询 "教研部" 的所有员工信息
-- a. 查询 教研部 的部门ID - tb_dept
select id
from tb_dept
where name = '教研部';

-- b. 再查询该部门ID下的员工信息 - tb_emp
select *
from tb_emp
where dept_id = (select id from tb_dept where name = '教研部');


-- B. 查询在 "方东白" 入职之后的员工信息
-- a. 查询 方东白 的入职时间
select entrydate
from tb_emp
where name = '方东白';

-- b. 查询在 "方东白" 入职之后的员工信息
select *
from tb_emp
where entrydate > (select entrydate from tb_emp where name = '方东白');



-- 列子查询
-- A. 查询 "教研部" 和 "咨询部" 的所有员工信息
-- a. 查询 "教研部" 和 "咨询部" 的部门ID - tb_dept
select id
from tb_dept
where name = '教研部'
   or name = '咨询部';

-- b. 根据部门ID, 查询该部门下的员工信息 - tb_emp
select *
from tb_emp
where dept_id in (select id from tb_dept where name = '教研部' or name = '咨询部');


-- 行子查询
-- A. 查询与 "韦一笑" 的入职日期 及 职位都相同的员工信息 ;
-- a. 查询 "韦一笑" 的入职日期 及 职位
select entrydate, job
from tb_emp
where name = '韦一笑';

-- b. 查询与其入职日期 及 职位都相同的员工信息 ;
-- 方式一
select *
from tb_emp
where entrydate = (select entrydate from tb_emp where name = '韦一笑')
  and job = (select job from tb_emp where name = '韦一笑');

select *
from tb_emp
where entrydate = '2007-01-01'
  and job = 2;

-- 方式二
select *
from tb_emp
where (entrydate, job) = (select entrydate, job from tb_emp where name = '韦一笑');


-- 表子查询
-- A. 查询入职日期是 "2006-01-01" 之后的员工信息 , 及其部门名称
-- a. 查询入职日期是 "2006-01-01" 之后的员工信息
select *
from tb_emp
where entrydate > '2006-01-01';

-- b. 查询这部分员工信息及其部门名称 - tb_dept
select e.*, d.name
from (select * from tb_emp where entrydate > '2006-01-01') e,
     tb_dept d
where e.dept_id = d.id;


