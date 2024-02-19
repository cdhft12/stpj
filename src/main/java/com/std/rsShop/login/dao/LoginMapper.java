package com.std.rsShop.login.dao;

import com.std.rsShop.login.vo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.Optional;

@Mapper
public interface LoginMapper {
    Optional<UserInfo> findByLoginId(String loginId);
}
