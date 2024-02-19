package com.std.rsShop.login.controller;

import com.std.rsShop.login.dto.TokenInfo;
import com.std.rsShop.login.service.LoginService;
import com.std.rsShop.login.vo.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class LoginController {
    private final LoginService loginservice;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody UserInfo userinfo) {
        String memberId = userinfo.getLoginId();
        String password = userinfo.getPassword();
        TokenInfo tokenInfo = loginservice.login(memberId, password);
        return tokenInfo;
    }

    @PostMapping("/test")
    public String test() {
        return "success";
    }
}


