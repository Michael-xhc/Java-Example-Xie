package cn.com.sinosafe.xieapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HaxbOutsourceXieApiApplication.class)
public class HaxbOutsourceXieApiApplication {

    @Test
    public void contextLoads() {
       int[] nums = {1,2,3,4,5,6,7,8,9};
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
