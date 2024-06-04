package com.code.BusinessSecurity.domain.impl;

import com.code.BusinessSecurity.domain.aggregates.request.SignInRequest;
import com.code.BusinessSecurity.domain.aggregates.response.AuthenticationResponse;
import com.code.BusinessSecurity.domain.ports.in.AuthenticationServiceIn;
import com.code.BusinessSecurity.domain.ports.out.AuthenticationServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationServiceIn {

    private final AuthenticationServiceOut authenticationServiceOut;

    @Override
    public AuthenticationResponse signinIn(SignInRequest signInRequest) {
        return authenticationServiceOut.signinOut(signInRequest);
    }

}
