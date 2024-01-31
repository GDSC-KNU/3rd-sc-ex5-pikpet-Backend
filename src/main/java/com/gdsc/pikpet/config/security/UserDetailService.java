package com.gdsc.pikpet.config.security;

import com.gdsc.pikpet.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailService implements UserDetailsService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailService(UserAccountRepository userAccountRepository,PasswordEncoder passwordEncoder){
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return UserSecurityDto.from(userAccountRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: " + username)));
    }
}