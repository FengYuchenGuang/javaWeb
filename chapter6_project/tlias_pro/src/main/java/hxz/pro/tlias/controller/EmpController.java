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
     * 分页查询 （自己编写全部代码，计数，分页， limit，下面有使用插件获取的方法，可以学习）
     * @param page
     * @param pageSize
     * @return
     */
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
     * 条件查询
     *
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


    /**
     * 删除员工（单个、批量都行）
     * @param ids
     * @return
     */
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
        log.info("新增员工:  {}" , emp);

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