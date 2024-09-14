package hxz.springboot.web02.service;

import hxz.springboot.web02.dao.BasicDao;
import hxz.springboot.web02.dao.EmpDao;
import hxz.springboot.web02.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hxz
 * 三层架构，2、业务逻辑层 进行调用 3、数据访问层 ，实现 业务逻辑层 功能
 */

@Primary //当有多个 BasicService 定义的 Bean 出现冲突时（即同类型的Bean有多个），该注解有的则被注入，不会出现报错

//将当前对象交给IOC容器管理,成为IOC容器的bean
@Component//("abcempService") //定义该容器的容器名
public class EmpService implements BasicService{
    /**
     * 与 EmpDao 进行耦合 需要进行 分层解耦
     *
     * @Autowired 运行时,需要从IOC容器中获取该类型对象,赋值给该变量
     */
    @Autowired
    private BasicDao empDao;

    @Override
    public List<Emp> listEmp() {
        //1. 调用dao, 获取数据
        List<Emp> empList = empDao.listEmp();

        //2. 对数据进行转换处理 - gender, job
        empList.stream().forEach((emp) -> {
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

        return empList;
    }
}
