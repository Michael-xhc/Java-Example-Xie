/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xie.cost.service.impl
 * fileName: costServiceImpl.java
 * date: 2020-03-17 16:12
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xie.cost.service.impl;

import cn.com.sinosafe.xie.cost.service.CostService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @description: 费用
 * @packageName: cn.com.sinosafe.xie.cost.service.impl
 * @className: costServiceImpl
 * @author: xiehanchun
 * @data: 2020-03-17 16:12
 * @version: 1.0
 **/
//@Component
@Service
public class CostServiceImpl implements CostService {

    @Override
    public String returnUrl() {
        String str = "1";
        return str;
    }
}
