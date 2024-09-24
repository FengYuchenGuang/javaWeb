package hxz.pro.tlias.Utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hxz
 */
@Data
@Component
@ConfigurationProperties(
        prefix = "aliyun.oss"
)
public class AliOSSProperties {
//    /**
//     * 使用 properties 文件进行参数配置
//     */
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId;
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret;
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;


    /**
     * 使用 yml 文件进行参数配置
     */
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}


