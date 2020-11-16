package cn.com.sinosafe.xiecommon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiehanchun on 2020/11/16
 */
public final class LogUtil {
    /** 根日志: 在类里面使用 LoggerFactory.getLogger(XXX.class) 跟这种方式一样! */
    public static final Logger ROOT_LOG = LoggerFactory.getLogger("root");
}
