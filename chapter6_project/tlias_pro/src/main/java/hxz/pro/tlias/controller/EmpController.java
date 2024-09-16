package hxz.pro.tlias.controller;

import hxz.pro.tlias.pojo.Dept;
import hxz.pro.tlias.pojo.Emp;
import hxz.pro.tlias.pojo.PageBean;
import hxz.pro.tlias.pojo.Result;
import hxz.pro.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
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

    @RequestMapping("/page")
    public Result page(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询, 参数: {},{}",page,pageSize);

        //调用service分页查询
        List<Emp> empList;
        try {
            empList = empService.page(page,pageSize);

        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success(empList);
    }

    /**
     * 如果变量名称和参数名称不同，可以使用 name 属性配置 @RequestParam 名称
     *
     * 如果传递参数可以为空 ，需要写上 required= false
     *
     * json参数 需要 @RequestBody 封装到对象中
     * @RequestBody 可以将 json 格式的请求数据 封装到 User 对象中
     */
    @PostMapping("/query")
    public Result query(@RequestParam(name = "name", required = false)String name,
                        @RequestParam(name = "gender", required = false)Short gender,
                        @RequestParam(name = "createTime", required = false) LocalDate start,
                        @RequestParam(name = "updateTime", required = false) LocalDate end){

        log.info("条件查询, 参数: {}, {}, {}, {}",name,gender,start,end);
        //调用service分页查询
        List<Emp> empList;
        try {
            empList = empService.query(name,gender,start,end);

        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success(empList);
    }
//    @PostMapping("/query")
//    public Result query(@RequestParam(name = "name", required = false)String name,
//                        @RequestParam(name = "gender", required = false)Short gender,
//                        @RequestParam(name = "createTime", required = false) LocalDate createTime,
//                        @RequestParam(name = "updateTime", required = false) LocalDate updateTime){
//
//        log.info("条件查询, 参数: {}, {}, {}, {}",name,gender,createTime,updateTime);
//        //调用service分页查询
//        List<Emp> empList;
//        try {
//            empList = empService.query(name,gender,createTime,updateTime);
//
//        }catch (Exception e){
//            return Result.error(e.getMessage());
//        }
//
//        return Result.success(empList);
//    }


//    @RequestMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name, Short gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
//        //调用service分页查询
//        List<Emp> empList = empService.page(page,pageSize,name,gender,begin,end);
//        return Result.success(empList);
//    }


//    @RequestMapping(value = "/deletes",method = RequestMethod.POST)
    @RequestMapping(value = "/deletes")
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);
        log.info(ids.getClass().toString());

        int row;
        try {
            row = empService.deletes(ids);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        if(row == 0){
            return Result.error("删除失败！！！");
        }
        return Result.success("成功删除");
    }


    /**
     * 新增员工
     * @return
     */
    @PostMapping("/insert")
    public Result add(@RequestBody Emp emp){
        log.info("新增部门: {}" , emp);

        //try-catch 出现错误时不结束，返回错误信息
        int row;
        try {
            row = empService.add(emp);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        if(row == 0){
            return Result.error("添加失败！！！");
        }
        return Result.success("添加员工成功");
    }
}