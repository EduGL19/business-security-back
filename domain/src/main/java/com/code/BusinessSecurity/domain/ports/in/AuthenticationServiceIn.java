package com.code.BusinessSecurity.domain.ports.in;

import com.code.BusinessSecurity.domain.aggregates.request.SignInRequest;
import com.code.BusinessSecurity.domain.aggregates.response.AuthenticationResponse;

public interface AuthenticationServiceIn {
    AuthenticationResponse signinIn(SignInRequest signInRequest);
}
