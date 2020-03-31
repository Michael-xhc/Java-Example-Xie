package cn.com.sinosafe.xiecommon.page;

import cn.com.sinosafe.xiecommon.utils.StringUtils;
import com.github.pagehelper.PageHelper;

/**
 * @author xiehanchun
 * @Title:
 * @Package
 * @Description: 分页工具
 * @date
 */
public class PageUtils {

    /**
     * @Description //设置请求分页数据
     * @Author xiehanchun
     * @Date 2020/3/31 11:34
     * @Param [pageNum, pageSize]
     * @return void
     */
    public static void startPage(Integer pageNum, Integer pageSize) {
        if(StringUtils.isNull(pageNum) || StringUtils.isNull(pageSize)) {
            pageNum = 1;
            pageSize = 10;
        }
        PageDomain pageDomain = new PageDomain();
        // 当前页
        pageDomain.setPageNum(pageNum);
        // 每页显示记录数
        pageDomain.setPageSize(pageSize);
        String orderBy = pageDomain.getOrderBy();
        PageHelper.startPage(pageNum, pageSize, orderBy);
    }
}
