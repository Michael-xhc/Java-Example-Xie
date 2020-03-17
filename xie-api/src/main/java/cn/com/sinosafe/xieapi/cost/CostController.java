/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.cost
 * fileName: costController.java
 * date: 2020-03-17 16:10
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.cost;

import cn.com.sinosafe.xie.cost.service.CostService;
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
    @Autowired
    private CostService costService;

    @PostMapping("/returnUrl")
    public String returnUrl(){
        return "1";
    }
}
