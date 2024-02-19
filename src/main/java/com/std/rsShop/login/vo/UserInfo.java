package com.std.rsShop.login.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private String id;
    private String loginId;
    private String password;
    private String name;
    private String gender;
    private String birthday;
    private String deleteYn;
    private String createdDate;
    private String modifiedDate;
    private String emai;
}
