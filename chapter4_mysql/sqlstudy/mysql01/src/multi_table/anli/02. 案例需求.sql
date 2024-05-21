-- 需求:
-- 1. 查询价格低于 10元 的菜品的名称 、价格 及其 菜品的分类名称 .
-- 表: dish , category
-- SQL:
select d.name, d.price, c.name
from dish d,
     category c
where d.category_id = c.id
  and d.price < 10;

-- 2. 查询所有价格在 10元(含)到50元(含)之间 且 状态为'起售'的菜品,
--    展示出菜品的名称、价格 及其 菜品的分类名称 (即使菜品没有分类 , 也需要将菜品查询出来).
-- 表: dish , category
-- SQL:
select d.name, d.price, c.name
from dish d
         left join category c on d.category_id = c.id
where d.price between 10 and 50
  and d.status = 1;

-- 3. 查询每个分类下最贵的菜品, 展示出分类的名称、最贵的菜品的价格 .
-- 表: dish , category
-- SQL:
select c.name, max(d.price)
from dish d,
     category c
where d.category_id = c.id
group by c.name;

-- 4. 查询各个分类下 菜品状态为 '起售' , 并且 该分类下菜品总数量大于等于3 的 分类名称 .
-- 表: dish , category
-- SQL:
select c.name, count(*)
from dish d,
     category c
where d.category_id = c.id
  and d.status = 1
group by c.name
having count(*) >= 3;

-- 5. 查询出 "商务套餐A" 中包含了哪些菜品 （展示出套餐名称、价格, 包含的菜品名称、价格、份数）.
-- 表: setmeal , setmeal_dish , dish
-- SQL:
select s.name, s.price, d.name, d.price, sd.copies
from setmeal s,
     setmeal_dish sd,
     dish d
where s.id = sd.setmeal_id
  and sd.dish_id = d.id
  and s.name = '商务套餐A';

-- 6. 查询出低于菜品平均价格的菜品信息 (展示出菜品名称、菜品价格).
-- 表: dish
-- SQL:
-- a. 计算 菜品平均价格
select avg(price)
from dish;

-- b. 查询出低于菜品平均价格的菜品信息
select *
from dish
where price < (select avg(price) from dish);


