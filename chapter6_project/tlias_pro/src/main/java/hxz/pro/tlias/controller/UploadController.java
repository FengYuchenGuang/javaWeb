package hxz.pro.tlias.controller;

import hxz.pro.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author hxz
 */
@Slf4j
@RestController
public class UploadController {

    //本地存储文件
    @PostMapping("/upload1")
    public Result upload(String username , Integer age , MultipartFile image) throws Exception {
        log.info("文件上传: {}, {}, {}", username, age, image);
        //获取原始文件名 - 1.jpg  123.0.0.jpg
        String originalFilename = image.getOriginalFilename();

        //构造唯一的文件名 (不能重复) - uuid(通用唯一识别码) de49685b-61c0-4b11-80fa-c71e95924018
        int index = originalFilename.lastIndexOf("."); //获取文件类型   . 后面的 .jpg, .png, .txt (包括.)
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名: {}", newFileName);

        //将文件存储在服务器的磁盘目录中 E:\images
        image.transferTo(new File("D:\\"+newFileName));

        return Result.success();
    }


//    @PostMapping("/upload2")
//    public Result upload(MultipartFile image) throws IOException {
//        log.info("文件上传, 文件名: {}", image.getOriginalFilename());
//
//        //调用阿里云OSS工具类进行文件上传
//        String url = aliOSSUtils.upload(image);
//        log.info("文件上传完成,文件访问的url: {}", url);
//
//        return Result.success(url);
//    }


}
