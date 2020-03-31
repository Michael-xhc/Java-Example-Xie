package cn.com.sinosafe.xie.user.mapper;

import cn.com.sinosafe.xie.user.domain.UserBaseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserBaseInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserBaseInfo record);

    int insertSelective(UserBaseInfo record);

    UserBaseInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserBaseInfo record);

    int updateByPrimaryKey(UserBaseInfo record);

    UserBaseInfo selectByPhone(String phone);

    List<UserBaseInfo> selectUserBaseInfo();
}