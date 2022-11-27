package com.sunglowsys.service.impl;

import com.sunglowsys.domain.Role;
import com.sunglowsys.domain.User;
import com.sunglowsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private  UserRepository userRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> opt  = userRepository.findByUsername(username);
        org.springframework.security.core.userdetails.User springUser = null;

        if (opt==null) {
            throw new UsernameNotFoundException("User with Email :"+username+" not found");
        }

        else {
            User user = opt.get();
         Set<Role> roles = user.getRoles();
         Set<GrantedAuthority> authorities = new HashSet<>();
         for (Role role: roles) {
             authorities.add(new SimpleGrantedAuthority(role.getRoles()));
         }

         springUser = new org.springframework.security.core.userdetails.User(username, user.getPassword(),authorities);
        }
        return springUser;
    }
}
