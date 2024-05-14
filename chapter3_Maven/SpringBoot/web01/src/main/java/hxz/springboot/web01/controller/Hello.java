package hxz.springboot.web01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxz
 */
@RestController
public class Hello {
    @RequestMapping("/helloHxz")
    public String hello1() {
        System.out.println("hello springboot~~~");
        return "hello springboot~~~~" ;
    }
}
