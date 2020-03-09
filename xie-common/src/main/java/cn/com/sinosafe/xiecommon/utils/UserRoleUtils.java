package cn.com.sinosafe.xiecommon.utils;

import cn.com.sinosafe.lina.UmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: cn.com.sinosafe.agent.common.utils
 * @NAME: UserRoleUtils
 * @description: 用户角色工具类
 * @USER:liyong
 * @time:2020-03-02 下午 2:33
 * @Version : 1.0
 **/
@Component
public class UserRoleUtils {

    @Autowired
    private UmService umService;

    /**
     *  @author: liyong
     *  @Date: 2020-03-02 下午 2:53
     *  @Description: 是否是管理员角色
     */
    public boolean isAdminRole(String userCode,String sysCode){
        List<Map<String, Object>> userAllRoles = umService.findUserAllRoles(userCode, sysCode);
        if(!CollectionUtils.isEmpty(userAllRoles)){
            for (Map<String, Object> userAllRole : userAllRoles) {
                for (Map.Entry<String, Object> stringObjectEntry : userAllRole.entrySet()) {
                    String value = (String)stringObjectEntry.getValue();
                    if("admin".equals(value)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
