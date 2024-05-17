--  =================== DQL: 条件查询 ======================

--  =================== 条件查询 ======================
-- 1. 查询 姓名 为 杨逍 的员工
select * from emp where name = '杨逍';

-- 2. 查询在 id小于等于5 的员工信息
select * from emp where id <= 5;

-- 3. 查询 没有分配职位 的员工信息  -- 判断 null , 用 is null
select * from emp where job is null;

-- 4. 查询 有职位 的员工信息  -- 判断 不是null , 用 is not null
select * from emp where job is not null ;

-- 5. 查询 密码不等于 '123456' 的员工信息
select * from emp where password <> '123456';
select * from emp where password != '123456';

-- 6. 查询入职日期 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间的员工信息
select * from emp where entrydate between '2000-01-01' and '2010-01-01' ;

-- 7. 查询 入职时间 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间 且 性别为女 的员工信息
select * from emp where (entrydate between '2000-01-01' and '2010-01-01') and  gender = 2;

-- 8. 查询 职位是 2 (讲师), 3 (学工主管), 4 (教研主管) 的员工信息
select * from emp where job = 2 or job = 3 or job = 4;

select * from emp where job in (2,3,4);

-- 9. 查询姓名为两个字的员工信息
select * from emp where name like '__';

-- 10. 查询姓 '张' 的员工信息  ---------> 张%
select * from emp where name like '张%';

-- 11. 查询姓名中包含 '三' 的员工信息
select * from emp where name like '%三%';




-- 练习 : 员工管理列表查询
-- 条件 : name , gender , entrydate

select * from emp where name like '%张%' and gender = 1 and entrydate between '2000-01-01' and '2010-01-01';



