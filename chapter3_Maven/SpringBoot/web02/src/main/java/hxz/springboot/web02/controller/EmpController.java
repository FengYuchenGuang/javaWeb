package hxz.springboot.web02.controller;

import hxz.springboot.web02.pojo.Emp;
import hxz.springboot.web02.pojo.Result;
import hxz.springboot.web02.service.BasicService;
import hxz.springboot.web02.service.EmpService;
import hxz.springboot.web02.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 三层架构，1、控制层 里定义 2、业务逻辑层 进行调用 2 ，实现控制层功能
 */
@RestController
public class EmpController {

    /**
     * 与 EmpService 进行耦合 需要进行 分层解耦
     *
     * @Autowired 运行时,需要从IOC容器中获取该类型对象,赋值给该变量
     */
//    private BasicService empService = new EmpService();
//    @Qualifier("basicService")
    @Autowired
    private BasicService empService;

//    @Resource(name = "abcempService")
//    private EmpService empService ;

    @RequestMapping("/listEmp")
    public Result list(){
        //1. 调用service, 获取数据
        List<Emp> empList = empService.listEmp();

        //3. 响应数据
        return Result.success(empList);
    }


/*  @RequestMapping("/listEmp")
    public Result list(){
        //1. 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        //2. 对数据进行转换处理 - gender, job
        empList.stream().forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });

        //3. 响应数据
        return Result.success(empList);
    }
*/
}
