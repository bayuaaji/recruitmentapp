package com.dansmultipro.recruitmentapp.services;

import com.dansmultipro.recruitmentapp.dto.AuthenticationRequest;
import com.dansmultipro.recruitmentapp.dto.AuthenticationResponse;
import com.dansmultipro.recruitmentapp.dto.RegisterRequest;

public interface UserService {

    AuthenticationResponse login(AuthenticationRequest request);

    AuthenticationResponse register(RegisterRequest request);


}
