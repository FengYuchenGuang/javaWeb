--  =================== 分页查询 ======================

--  =================== 分页查询 ======================
-- 1. 查询第1页员工数据, 每页展示10条记录
select * from emp limit 0,10;

select * from emp limit 10;


-- 2. 查询第2页员工数据, 每页展示10条记录
select * from emp limit 10,10;

-- 公式 : 页码 ---> 起始索引  ------->  起始索引 = (页码 - 1) * 每页记录数




-- 练习 : 员工管理列表查询 , 根据最后操作时间, 进行倒序排序
-- 条件 : name , gender , entrydate

select * from emp where name like '%张%' and gender = 1 and entrydate between '2000-01-01' and '2010-01-01' order by update_time desc limit 0,10 ;