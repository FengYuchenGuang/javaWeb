-- ====================================> DQL <=======================================

--  =================== 基本查询 ======================
-- 1. 查询指定字段 name,entrydate 并返回
select name,entrydate from emp ;


-- 2. 查询返回所有字段
-- 方式一:  推荐 , 效率高 . 更直观
select id, username, password, name, gender, image, job, entrydate, create_time, update_time from emp;


-- 方式二:
select * from emp;


-- 3. 查询所有员工的 name,entrydate, 并起别名(姓名、入职日期)  --- as 关键字可以省略
select name as '姓名' ,entrydate as '入职日期' from emp ;

select name '姓名' ,entrydate '入职日期' from emp ;


-- 4. 查询员工有哪几种职位(不要重复) -- distinct
select distinct job from emp;



select * from emp where id = 1;