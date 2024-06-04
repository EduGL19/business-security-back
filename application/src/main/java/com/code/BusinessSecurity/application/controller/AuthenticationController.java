package com.code.BusinessSecurity.application.controller;

import com.code.BusinessSecurity.domain.aggregates.request.SignInRequest;
import com.code.BusinessSecurity.domain.aggregates.response.AuthenticationResponse;
import com.code.BusinessSecurity.domain.ports.in.AuthenticationServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BusinessSecurity/v1/authentication")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationServiceIn authenticationServiceIn;

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationServiceIn.signinIn(signInRequest));
    }

}
