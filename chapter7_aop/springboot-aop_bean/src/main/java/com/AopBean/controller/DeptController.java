package com.AopBean.controller;



import com.AopBean.pojo.Dept;
import com.AopBean.pojo.Result;
import com.AopBean.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hxz
 * 员工管理 Controller
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
@RequestMapping("/depts")
@RestController
public class DeptController {
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET) //指定请求方式为GET
    @GetMapping("/list")
    public Result list(){
        log.info("查询全部部门数据");

        //调用service查询部门数据
        List<Dept> deptList;
        try {
            deptList =  deptService.list();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success(deptList);
    }

    /**
     * ===========给 项目 nginx-1.22.0-tlias 写的控制层代码=================
     */

    @GetMapping
    public Result list_tlias(){
        log.info("查询全部部门数据");

        //调用service查询部门数据
        List<Dept> deptList;
        try {
            deptList =  deptService.list();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success(deptList);
    }

    /**
     * 删除部门 与 修改部门 都是同样类型的操作，使用路径参数
     *
     */

    @DeleteMapping("/{id}")
    public Result delete_tlias(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);

        //调用service删除部门
        int row;
        try {
            row = deptService.delete(id);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        if(row == 0){
            return Result.error("删除失败！！！");
        }
        return Result.success("成功删除");
    }

    /**
     * 修改部门由两个方法组成
     * 1、get 根据 id 获取指定部门信息
     * 2、根据 id 修改部门信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get_tlias(@PathVariable Integer id){
        log.info("get 部门 id: {}" , id);

        //调用service修改部门
        Dept dept;
        try {
            dept = deptService.get(id);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success(dept);
    }

    @PutMapping()
    public Result update_tlias(@RequestBody Dept dept){
        log.info("修改部门: {}" ,dept);

        //调用service修改部门
        int row;
        try {
            row = deptService.update(dept);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        if(row == 0){
            return Result.error("修改失败！！！");
        }
        return Result.success("修改部门成功");
    }


    @PostMapping
    public Result add_tlias(@RequestBody Dept dept){
        log.info("新增部门: {}" , dept);

        //调用service新增部门
        int row;
        row = deptService.add(dept); // 有添加全局异常捕获

        if(row == 0){
            return Result.error("添加失败！！！");
        }
        return Result.success("新增部门成功");
    }



}
