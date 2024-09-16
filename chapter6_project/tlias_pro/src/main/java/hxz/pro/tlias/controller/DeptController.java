package hxz.pro.tlias.controller;


import hxz.pro.tlias.pojo.Dept;
import hxz.pro.tlias.pojo.Result;
import hxz.pro.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * 查询部门数据
     * @return
     */

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
     * 删除部门
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
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
     * 新增部门
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Dept dept){
        log.info("新增部门: {}" , dept);

        //调用service新增部门
        int row;
        try {
            row = deptService.add(dept);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        if(row == 0){
            return Result.error("添加失败！！！");
        }
        return Result.success("新增部门成功");
    }
}
