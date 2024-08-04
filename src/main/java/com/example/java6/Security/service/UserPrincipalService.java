package com.example.java6.Security.service;

import com.example.java6.Entity.store.Account;
import com.example.java6.Service.AccountService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalService implements UserDetailsService {

    @Autowired
    private AccountService accountService;
//    @Autowired
//    BCryptPasswordEncoder pe;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = null;
        try {
            account = accountService.getAccountByUsername(username);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
        if (account == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);

        }
        return new UserPrincipal(account);
    }

//    public void loginFromOAuth2(OAuth2AuthenticationToken oauth2){
//        // String fullname = oauth2.getPrincipal().getAttribute("name");
//        String email = oauth2.getPrincipal().getAttribute("email");
//        String password = Long.toHexString(System.currentTimeMillis());
//
//        UserDetails user = User.withUsername(email)
//                .password(pe.encode(password)).roles("GUEST").build();
//        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(auth);
//    }
}
