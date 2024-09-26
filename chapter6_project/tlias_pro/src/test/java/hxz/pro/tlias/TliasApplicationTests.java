package hxz.pro.tlias;

import hxz.pro.tlias.Utils.AliOSSProperties;
import hxz.pro.tlias.mapper.EmpMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 测试 JWT令牌 的生成
     *
     */
    @Test
    public void test_jwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","FenYuChen");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "hxz_BuNengTaiDuan")  //签名算法
                .setClaims(claims) //自定义内容（载荷）
                // JWT 令牌的有效期为 一天（当前时间加上 一天）
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 3600 * 1000))
                .compact();

        log.info("JWT令牌 = {}",jwt);
    }

    /**
     *  JWT令牌 的解析
     *
     */
    @Test
    public void test_ParseJWT(){
        Claims claims = Jwts.parser()
                .setSigningKey("hxz_BuNengTaiDuan")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiRmVuWXVDaGVuIiwiaWQiOjEsImV4cCI6MTcyNzM1OTk5OX0.ukladACbdZUQ1E6EyHSBpyhC-IdKnI66Ebh0RGEG9NA")
                .getBody();

        log.info("\n {}",claims);
    }
}
