/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.cost
 * fileName: costController.java
 * date: 2020-03-17 16:10
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.cost;

import cn.com.sinosafe.xiecommon.annotation.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: 费用
 * @packageName: cn.com.sinosafe.xieapi.cost
 * @className: costController
 * @author: xiehanchun
 * @data: 2020-03-17 16:10
 * @version: v1.0
 **/
@RestController
@RequestMapping("/api/cost")
public class CostController {
//    @Autowired
//    private CostService costService;

    @PostMapping("/returnUrl")
    @Authentication
    public String returnUrl(){
        System.out.println("方法returnUrl");
        return null;
    }

    public static void main(String[] args) {
//        Builder  builder = new Builder();
//        builder.setName("xiehanchun").setMaxIdle(30).setMinIdle(2).setMaxTotal(10).build();
//        BuilderPattern build = new BuilderPattern.Builder().setName("xiehanchun").setMaxIdle(9).setMinIdle(20).setMaxTotal(10).build();
//        System.out.println(build.getName());
        ValidParentheses validParentheses = new ValidParentheses();
        boolean b = validParentheses.isValid("([)]");
        System.out.println(b);
    }
}
