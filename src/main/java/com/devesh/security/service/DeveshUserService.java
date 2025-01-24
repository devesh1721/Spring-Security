package com.devesh.security.service;

import com.devesh.security.model.DeveshUser;
import com.devesh.security.repostiory.DeveshUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DeveshUserService {

    @Autowired
    private DeveshUserRepository deveshUserRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public DeveshUser registerUser(DeveshUser deveshUser){
        deveshUser.setPassword(bCryptPasswordEncoder.encode(deveshUser.getPassword()));
       return  this.deveshUserRepository.save(deveshUser);
    }

    public String verifyUser(DeveshUser deveshUser){
        Authentication  authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(deveshUser.getName(), deveshUser.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtTokenService.generateToken(deveshUser.getName(), "user");
        }
        return "fail";
    }
}
