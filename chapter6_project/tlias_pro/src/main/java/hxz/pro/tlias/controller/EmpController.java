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
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/page")
    public Result page(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询, 参数: {},{}",page,pageSize);
        //调用service分页查询
        List<Emp> empList = empService.page(page,pageSize);
        return Result.success(empList);
    }


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

        int row = empService.deletes(ids);

        if(row == 0){
            return Result.error("删除失败！！！");
        }
        return Result.success();
    }


    /**
     * 新增员工
     * @return
     */
    @PostMapping("/insert")
    public Result add(@RequestBody Emp emp){
        log.info("新增部门: {}" , emp);

        //try-catch 出现错误时不结束，返回错误信息
        try {
            int row = empService.add(emp);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

        return Result.success("添加员工成功");
    }
}