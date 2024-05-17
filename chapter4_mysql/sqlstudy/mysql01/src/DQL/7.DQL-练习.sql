-- 男性与女性员工的人数统计 (1 : 男性员工 , 2 : 女性员工)
-- 函数: if(条件表达式 , t , f)
select if(gender = 1, '男性员工', '女性员工') '性别',
       count(*)                       '人数'
from emp
group by gender;


-- 员工职位信息 -- count
-- 函数: case when ... then ... when ... then ... else ... end
-- 函数: case ... when ... then ... when ... then ... else ... end
select (case
            when job = 1 then '班主任'
            when job = 2 then '讲师'
            when job = 3 then '教研主管'
            when job = 4 then '学工主管'
            else '无职位' end) '职位',
       count(*)
from emp
group by job;

select (case job
            when 1 then '班主任'
            when 2 then '讲师'
            when 3 then '教研主管'
            when 4 then '学工主管'
            else '无职位' end) '职位',
       count(*)
from emp
group by job;



