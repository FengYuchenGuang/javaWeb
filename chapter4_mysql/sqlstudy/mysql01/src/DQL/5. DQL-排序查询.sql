--  =================== 排序查询 ======================

--  =================== 排序查询 ======================
-- 1. 根据入职时间, 对员工进行升序排序  -- 排序条件
select * from emp order by entrydate asc ; -- 默认升序, asc可以省略的

select * from emp order by entrydate ;

-- 2. 根据入职时间, 对员工进行降序排序
select * from emp order by entrydate desc;


-- 3. 根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 ID 进行降序排序
select * from emp order by entrydate asc , id desc ;


-- 练习 : 员工管理列表查询 , 根据最后操作时间, 进行倒序排序
-- 条件 : name , gender , entrydate

select * from emp where name like '%张%' and gender = 1 and entrydate between '2000-01-01' and '2010-01-01' order by update_time desc;


