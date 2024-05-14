package hxz.springboot.web02.service;

import hxz.springboot.web02.dao.BasicDao;
import hxz.springboot.web02.dao.EmpDao;
import hxz.springboot.web02.pojo.Emp;

import java.util.List;

/**
 * @author hxz
 * 三层架构，2、业务逻辑层 进行调用 3、数据访问层 ，实现 业务逻辑层 功能
 */
public class EmpService implements BasicService{
    private BasicDao empDao = new EmpDao();

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
