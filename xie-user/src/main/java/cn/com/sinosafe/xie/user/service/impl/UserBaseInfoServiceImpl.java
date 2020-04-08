/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xie.user.service.impl
 * fileName: UserBaseInfoServiceImpl.java
 * date: 2020-03-31 11:50
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xie.user.service.impl;

import cn.com.sinosafe.xie.user.domain.Node;
import cn.com.sinosafe.xie.user.domain.UserBaseInfo;
import cn.com.sinosafe.xie.user.mapper.UserBaseInfoMapper;
import cn.com.sinosafe.xie.user.service.UserBaseInfoService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 用户
 * @packageName: cn.com.sinosafe.xie.user.service.impl
 * @className: UserBaseInfoServiceImpl
 * @author: xiehanchun
 * @data: 2020-03-31 11:50
 * @version: v1.0
 */
@Service
public class UserBaseInfoServiceImpl implements UserBaseInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserBaseInfoServiceImpl.class);
    private int sum = 0;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Override
    public List<UserBaseInfo> selectUserBaseInfo(JSONObject req) throws Exception{
        return userBaseInfoMapper.selectUserBaseInfo(req);
    }

    @Override
    public Node convertBST(Node root) throws Exception {
            if (root != null) {
                convertBST(root.right);
                sum += root.data;
                root.data = sum;
                convertBST(root.left);
            }
            return root;
    }
}
