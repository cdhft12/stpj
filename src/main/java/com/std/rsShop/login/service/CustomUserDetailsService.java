package com.std.rsShop.login.service;

import com.std.rsShop.login.dao.LoginMapper;
import com.std.rsShop.login.vo.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class CustomUserDetailsService implements UserDetailsService{
    private final LoginMapper loginMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginMapper.findByLoginId(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

    // 해당하는 User 의 데이터가 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(UserInfo member) {
        return User.builder()
                .username(member.getLoginId())
                .password(passwordEncoder.encode(member.getPassword()))
                // .roles(member.getRoles().toArray(new String[0]))
                .roles("USER")//일단 접근 권한을 유저로 해놨음 추후 변경할것
                .build();
    }
}
