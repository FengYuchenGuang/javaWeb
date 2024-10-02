package com.AopBean.controller;


import com.AopBean.anno.hxzLog;
import com.AopBean.pojo.Emp;
import com.AopBean.pojo.PageBean;
import com.AopBean.pojo.Result;
import com.AopBean.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hxz
 * 部门管理Controller
 */

/**
 * @RequestMapping(value = "/depts",method = RequestMethod.GET) //指定请求方式为GET
 *
 * 想要指定请求方式，@RequestMapping 又太繁琐，
 * 可以使用其衍生注解
 * @GetMapping
 * @PostMapping
 * @PutMapping
 * @DeleteMapping
 * 等
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 查询全部内容
     * @return
     */
    @GetMapping("/list")
    public Result list(){

        log.info("查询全部 emps 内容");

        //调用service分页查询
        List<Emp> empList;
        try {
            empList = empService.list();

        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success(empList);
    }


    /**
     * ===========给 项目 nginx-1.22.0-tlias 写的控制层代码=================
     */

    /**
     * 分页查询 （使用 pagehelper 简化代码）
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    @RequestMapping
    public Result page_tlias(@RequestParam(defaultValue = "0") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String name, Short gender,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);

        //调用service分页查询
        List<Emp> empList;
        PageBean pageBean;
        try {
            pageBean = empService.page_tlias(page,pageSize,name,gender,begin,end);

        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success(pageBean);
    }



    /**
     * 添加员工
     *
     */
    @PostMapping
    @hxzLog
    public Result insert_tlias(@RequestBody Emp emp){
        log.info("新增员工: {}" , emp);

        //try-catch 出现错误时不结束，返回错误信息
        int row;
        try {
            row = empService.insert_tlias(emp);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        if(row == 0){
            return Result.error("添加失败！！！");
        }
        return Result.success("添加员工成功");
    }

    @DeleteMapping("/{ids}")
    @hxzLog
    public Result delete_tlias(@PathVariable List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);

        int row;
        try {
            row = empService.delete_tlias(ids);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        if(row == 0){
            return Result.error("添加失败！！！");
        }

        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getById_tlias(@PathVariable Integer id){
        log.info("根据ID查询员工信息, id: {}",id);

        Emp emp;
        try {
            emp = empService.getById_tlias(id);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success(emp);
    }

    @PutMapping
    @hxzLog
    public Result update_tlias(@RequestBody Emp emp){
        log.info("更新员工信息 : {}", emp);

        int row;
        try {
            row = empService.update_tlias(emp);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        if(row == 0){
            return Result.error("添加失败！！！");
        }

        return Result.success();
    }
}