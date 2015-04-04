package com.ds.quiz.security;

import com.ds.quiz.dao.EntityDoesNotExistException;
import com.ds.quiz.infrastructure.crypt.CryptUtils;
import com.ds.quiz.model.User;
import com.ds.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by DS on 17.03.2015.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider{

    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = null;
        try {
            user = userService.findUser(username);
        } catch (EntityDoesNotExistException e) {
            throw new BadCredentialsException("Username not found");
        }

        password = CryptUtils.cryptPassword(password, user.getSalt());

        if(!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong Password");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
