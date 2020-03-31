package cn.com.sinosafe.xieapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cn.com.sinosafe")
@MapperScan("cn.com.sinosafe.xie.*.mapper")
public class HaxbOutsourceXieApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaxbOutsourceXieApiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  华安信保外包个人代理人项目客户端启动   ლ(´ڡ`ლ)ﾞ \n");
    }
}
