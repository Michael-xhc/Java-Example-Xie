package cn.com.sinosafe.xie.user.service;

import cn.com.sinosafe.xie.user.domain.UserBaseInfo;

import java.util.List;

public interface UserBaseInfoService {

    List<UserBaseInfo> selectUserBaseInfo() throws Exception;
}
