package com.code.BusinessSecurity.domain.impl;

import com.code.BusinessSecurity.domain.aggregates.dto.UserDto;
import com.code.BusinessSecurity.domain.aggregates.request.UsertRequest;
import com.code.BusinessSecurity.domain.ports.in.UserServiceIn;
import com.code.BusinessSecurity.domain.ports.out.UserServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceIn {

    private final UserServiceOut userServiceOut;

    @Override
    public UserDto createIn(UsertRequest usertRequest) {
        return userServiceOut.createOut(usertRequest);
    }

    @Override
    public Optional<UserDto> getIn(Long id) {
        return userServiceOut.getOut(id);
    }

    @Override
    public List<UserDto> listIn() {
        return userServiceOut.listOut();
    }

    @Override
    public UserDto updateIn(Long id, UsertRequest usertRequest) {
        return userServiceOut.updateOut(id,usertRequest);
    }

    @Override
    public UserDto deleteIn(Long id) {
        return userServiceOut.deleteOut(id);
    }

    @Override
    public UserDetailsService userDetailServiceIn() {
        return userServiceOut.userDetailServiceOut();
    }
}
