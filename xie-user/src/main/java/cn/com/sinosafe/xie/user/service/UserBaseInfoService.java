package cn.com.sinosafe.xie.user.service;

import cn.com.sinosafe.xie.user.domain.UserBaseInfo;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface UserBaseInfoService {

    List<UserBaseInfo> selectUserBaseInfo(JSONObject req) throws Exception;
}
