package com.code.BusinessSecurity.domain.ports.out;

import com.code.BusinessSecurity.domain.aggregates.request.SignInRequest;
import com.code.BusinessSecurity.domain.aggregates.response.AuthenticationResponse;

public interface AuthenticationServiceOut {
    AuthenticationResponse signinOut(SignInRequest signInRequest);
}
