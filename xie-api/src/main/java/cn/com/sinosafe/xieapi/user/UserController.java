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
import cn.com.sinosafe.xiecommon.utils.Md5Utils;
import cn.com.sinosafe.xiecommon.utils.RedisUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserBaseInfoService userBaseInfoService;
    @Autowired
    private RedisUtils redisUtils;

    private static final String REDIS_KEY = "redis_key123";

    /**
     * @Description //TODO
     * @Author xiehanchun
     * @Date 2020/3/31 14:58
     * @Param [req]
     * @return cn.com.sinosafe.xiecommon.utils.AgentJsonProtocol
     */
    @PostMapping("/getUserBaseInfo")
    public AgentJsonProtocol getUserBaseInfo(@RequestBody JSONObject req) throws Exception{
        Integer pageNum = req.getInteger("pageNum");
        Integer pageSize = req.getInteger("pageSize");
        PageUtils.startPage(pageNum,pageSize);
        Map<String,Object> map = new HashMap<>(8);
        List<UserBaseInfo> list = userBaseInfoService.selectUserBaseInfo(req);
        map.put("total",new PageInfo(list).getTotal());
        map.put("data",list);
        log.info("数据"+map);
        return AgentJsonProtocol.response(map);
    }

    @PostMapping("getRedis")
    public AgentJsonProtocol getRedis(@RequestBody JSONObject req) throws Exception{
//        String str = "18529350724";
//        String hash = Md5Utils.hash(str);
//        redisUtils.setValue(REDIS_KEY,hash);
        Object value = redisUtils.getValue(REDIS_KEY);
        return AgentJsonProtocol.response(value);
    }
}
