package hxz.pro.tlias;

import hxz.pro.tlias.Utils.AliOSSProperties;
import hxz.pro.tlias.mapper.EmpMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class TliasApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private AliOSSProperties aliOSSProperties;

    //根据ID删除
    @Test
    public void testDelete(){
        //int delete = empMapper.delete(16);
        //System.out.println(delete);
        empMapper.delete(17);
    }

    @Test
    public void test_aliyunoss(){
        log.info("\n aliyun.oss : endpoint = {}\n accessKeyId = {}\n accessKeySecret = {}\n bucketName = {}",
                aliOSSProperties.getEndpoint(),aliOSSProperties.getAccessKeyId(),
                aliOSSProperties.getAccessKeySecret(),aliOSSProperties.getBucketName());
    }
}
