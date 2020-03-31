package cn.com.sinosafe.xiecommon.utils;

import cn.com.sinosafe.xiecommon.code.AgentResponseCode;
import cn.com.sinosafe.xiecommon.code.ResultCode;
import cn.com.sinosafe.xiecommon.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;


/**
 * @ClassName:  ParamUtils   
 * @Description:参数验证公共类  
 * @author: xiehanchun
 * @date:   2020年2月11日 下午4:08:41      
 * @Copyright:
 */
public class ParamUtils {

    private static final Logger log = LoggerFactory.getLogger(ParamUtils.class);

    /**
     * 对象参数不能为空
     * 
     * @param obj
     */
        public static void notNull(Object obj, String name) {
        if (StringUtils.isNull(obj)) {
            log.error(String.format("参数校验失败,[%s]为空", name));
            throw new BusinessException(AgentResponseCode.NULL_PARAM, true, name);
        }
    }

    /**
     * 字符串不能为空
     * 
     * @param str
     */
    public static void notEmpty(String content, String name) {
        if (StringUtils.isEmpty(content)) {
            log.error(String.format("参数校验失败,[%s]为空", name));
            throw new BusinessException(AgentResponseCode.NULL_PARAM, true, name);
        }
    }

    /**
     * 格式正则匹配
     * 
     * @param reg
     * @param content
     */
    public static void regValidate(String reg, String content, ResultCode resultCode) {
        if (!Pattern.matches(reg, content)) {
            throw new BusinessException(resultCode);
        }
    }
    
    /**
    * @Desc    : 比较数值大小
    * @Author  : xiehanchun
    * @Date    : 2020年2月26日 上午10:19:49
    * @param a
    * @param b
    * @param name  :
     */
    public static void compareNum(int a, int b,String name) {
        if (a<b) {
            log.error(String.format("参数校验失败,[%s]为空", name));
            throw new BusinessException(AgentResponseCode.NULL_PARAM, true, name);
        }
    }

}
