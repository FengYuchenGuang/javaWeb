package hxz.pro.tlias;

import hxz.pro.tlias.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TliasApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    //根据ID删除
    @Test
    public void testDelete(){
        //int delete = empMapper.delete(16);
        //System.out.println(delete);
        empMapper.delete(17);
    }
}
