--  =================== DQL: 分组查询 ======================

--  =================== 分组查询 ======================
-- 聚合函数

-- 1. 统计该企业员工数量 -- count
-- A. count(字段)
select count(id) from emp;
select count(job) from emp; -- null值不参与聚合函数运算

-- B. count(*)
select count(*) from emp;

-- C. count(值)
select count(1) from emp;

-- 2. 统计该企业员工 ID 的平均值
select avg(id) from emp;

-- 3. 统计该企业最早入职的员工的入职日期
select min(entrydate) from emp;

-- 4. 统计该企业最近入职的员工的入职日期
select max(entrydate) from emp;

-- 5. 统计该企业员工的 ID 之和
select sum(id) from emp;




-- 分组
-- 1. 根据性别分组 , 统计男性和女性员工的数量  -- count
select gender , count(*) from emp group by gender;

-- 2. 先查询入职时间在 '2015-01-01' (包含) 以前的员工 , 并对结果根据职位分组 , 获取员工数量大于等于2的职位 -- count
select job ,count(*)  from emp where entrydate <= '2015-01-01'  group by job having count(*) >= 2;




