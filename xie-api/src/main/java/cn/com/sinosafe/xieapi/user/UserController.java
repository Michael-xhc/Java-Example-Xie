/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.user
 * fileName: UserController.java
 * date: 2020-03-31 11:38
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.user;

import cn.com.sinosafe.xie.user.domain.UserBaseInfo;
import cn.com.sinosafe.xie.user.service.UserBaseInfoService;
import cn.com.sinosafe.xiecommon.page.PageUtils;
import cn.com.sinosafe.xiecommon.utils.AgentJsonProtocol;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用户
 * @packageName: cn.com.sinosafe.xieapi.user
 * @className: UserController
 * @author: xiehanchun
 * @data: 2020-03-31 11:38
 * @version: v1.0
 */
@RestController
@RequestMapping("/app/user")
public class UserController {
    @Autowired
    private UserBaseInfoService userBaseInfoService;

    /**
     * @Description //TODO
     * @Author xiehanchun
     * @Date 2020/3/31 14:58
     * @Param [req]
     * @return cn.com.sinosafe.xiecommon.utils.AgentJsonProtocol
     */
    @PostMapping("/getUserBaseInfo")
    public AgentJsonProtocol getUserBaseInfo(@RequestParam JSONObject req) throws Exception{
        Integer pageNum = req.getInteger("pageNum");
        Integer pageSize = req.getInteger("pageSize");
        PageUtils.startPage(pageNum,pageSize);
        Map<String,Object> map = new HashMap<>(8);
        List<UserBaseInfo> list = userBaseInfoService.selectUserBaseInfo();
        map.put("total",new PageInfo(list).getTotal());
        map.put("data",list);
        return AgentJsonProtocol.response(map);
    }
}
