package com.code.BusinessSecurity.domain.aggregates.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private String token;
    private String refreshToken;
}
