package com.devesh.security.service;

import com.devesh.security.model.DeveshUser;
import com.devesh.security.repostiory.DeveshUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private DeveshUserRepository deveshUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DeveshUser deveshUser = deveshUserRepository.findByName(username);
        if(deveshUser == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(deveshUser);
    }
}
