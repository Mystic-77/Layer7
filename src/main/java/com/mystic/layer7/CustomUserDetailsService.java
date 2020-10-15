package com.mystic.layer7;

import com.mystic.layer7.entity.User;
import com.mystic.layer7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = userRepository.getUserByUsername(s);
        if(user != null)
        {
            GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(authority);
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
                    authorities);
        }
        return null;
    }
}
