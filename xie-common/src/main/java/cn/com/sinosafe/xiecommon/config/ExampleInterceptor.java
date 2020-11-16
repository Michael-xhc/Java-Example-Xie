package cn.com.sinosafe.xiecommon.config;

import cn.com.sinosafe.xiecommon.annotation.Authentication;
import cn.com.sinosafe.xiecommon.code.AgentResponseCode;
import cn.com.sinosafe.xiecommon.utils.LogUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiehanchun on 2020/11/16
 */
@Component
public class ExampleInterceptor implements HandlerInterceptor {
    private final static int POST_STATE_VALUE_NEW = -1;
    private final static int POST_STATE_VALUE_DOING = 0;
    private final static int POST_STATE_VALUE_SUCCESS = 1;
    private final static int POST_STATE_VALUE_FAILED = 2;

    private static final LoadingCache<String, Integer> LIMITER_MAP = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Integer>() {
                @Override
                public Integer load(String key) throws Exception {
                    return POST_STATE_VALUE_NEW;
                }
            });

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
//        LogUtil.ROOT_LOG.debug("RepeatPostInterceptor");
        Authentication forbiddenRepeatPost = getAnnotation((HandlerMethod) handler, Authentication.class);
        if (forbiddenRepeatPost != null) {

            if (StringUtils.endsWithIgnoreCase(request.getMethod(), HttpMethod.POST.name())) {
                String postId = request.getHeader(AgentResponseCode.POST_ID);
                if (StringUtils.isNotBlank(postId)) {
                    Integer value = LIMITER_MAP.get(postId);
                    switch (value) {
                        case POST_STATE_VALUE_NEW:
                            LIMITER_MAP.put(postId, POST_STATE_VALUE_DOING);
//                            LogUtil.ROOT_LOG.debug("新请求，不拦截。。。。");
                            return true;
                        case POST_STATE_VALUE_DOING:
                            throw new RuntimeException("请求处理中，请稍候");
                        case POST_STATE_VALUE_SUCCESS:
                            throw new RuntimeException("请不要重复提交");
                        case POST_STATE_VALUE_FAILED:
                            return true;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        if (StringUtils.endsWithIgnoreCase(request.getMethod(), HttpMethod.POST.name())) {


            String postId = request.getHeader(AgentResponseCode.POST_ID);
            if (StringUtils.isNotBlank(postId)) {

                if (ex != null) {
                    if (LogUtil.ROOT_LOG.isDebugEnabled()) {
                        LogUtil.ROOT_LOG.debug("request was over, but have exception: " + ex.getMessage());
                    }
                    LIMITER_MAP.put(postId, POST_STATE_VALUE_FAILED);

                }else {
                    LIMITER_MAP.put(postId, POST_STATE_VALUE_SUCCESS);
                }
            }
        }

    }

    private <T extends Annotation> T getAnnotation(HandlerMethod handlerMethod, Class<T> clazz) {
        // 先找方法上的注解, 没有再找类上的注解
        T annotation = handlerMethod.getMethodAnnotation(clazz);
        return annotation == null ? AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), clazz) : annotation;
    }

}
