-- ==================================== 事务 ===========================
-- 开启事务
start transaction ;

-- 删除部门
delete from tb_dept where id = 2;

-- 删除部门下的员工
delete from tb_emp where dept_id == 2;


-- 提交事务
commit;

-- 回滚事务
rollback ;


select * from tb_dept;
select * from tb_emp;





-- ================================ 索引 =============================
select * from tb_sku where sn = '100000003145008'; -- 14s


select count(*) from tb_sku;


create index idx_sku_sn on tb_sku(sn);



-- 创建 : 为tb_emp表的name字段建立一个索引 .
create index idx_emp_name on tb_emp(name);

-- 查询 : 查询 tb_emp 表的索引信息 .
show index from tb_emp;

-- 删除: 删除 tb_emp 表中name字段的索引 .
drop index idx_emp_name on tb_emp;