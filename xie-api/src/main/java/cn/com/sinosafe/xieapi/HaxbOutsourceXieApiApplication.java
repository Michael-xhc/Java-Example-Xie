package cn.com.sinosafe.xieapi;


@SpringBootApplication
@ComponentScan("cn.com.sinosafe")
@MapperScan("cn.com.sinosafe.xie.*.mapper")
@EnableHystrix
public class HaxbOutsourceXieApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaxbOutsourceXieApiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  华安信保外包个人代理人项目客户端启动   ლ(´ڡ`ლ)ﾞ \n");
    }
}
