package com.code.BusinessSecurity.Infraestructure.adapters;


import com.code.BusinessSecurity.Infraestructure.dao.RolRepository;
import com.code.BusinessSecurity.Infraestructure.dao.UserRepository;
import com.code.BusinessSecurity.domain.aggregates.request.SignInRequest;
import com.code.BusinessSecurity.domain.aggregates.response.AuthenticationResponse;
import com.code.BusinessSecurity.domain.ports.out.AuthenticationServiceOut;
import com.code.BusinessSecurity.domain.ports.out.JWTServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationAdapter implements AuthenticationServiceOut {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTServiceOut jwtServiceOut;

    @Override
    public AuthenticationResponse signinOut(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(),signInRequest.getPassword()));
        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("Email no valido"));

        var jwt = jwtServiceOut.generateTokenOut(user);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwt);
        return authenticationResponse;
    }
}
