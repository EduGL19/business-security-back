package com.code.BusinessSecurity.domain.ports.in;

import com.code.BusinessSecurity.domain.aggregates.dto.UserDto;
import com.code.BusinessSecurity.domain.aggregates.request.UsertRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserServiceIn {
    UserDto createIn(UsertRequest usertRequest);

    Optional<UserDto> getIn(Long id);

    List<UserDto> listIn();

    UserDto updateIn(Long id,UsertRequest usertRequest);

    UserDto deleteIn(Long id);

    UserDetailsService userDetailServiceIn();

}
