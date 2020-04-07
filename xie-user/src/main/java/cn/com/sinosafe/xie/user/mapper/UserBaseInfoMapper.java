package cn.com.sinosafe.xie.user.mapper;

import cn.com.sinosafe.xie.user.domain.UserBaseInfo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBaseInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserBaseInfo record);

    int insertSelective(UserBaseInfo record);

    UserBaseInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserBaseInfo record);

    int updateByPrimaryKey(UserBaseInfo record);

    UserBaseInfo selectByPhone(String phone);

    List<UserBaseInfo> selectUserBaseInfo(JSONObject req);

    List<UserBaseInfo> selectUserBase(int limit);
}