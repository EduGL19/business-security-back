package com.code.BusinessSecurity.domain.ports.out;

import com.code.BusinessSecurity.domain.aggregates.dto.UserDto;
import com.code.BusinessSecurity.domain.aggregates.request.UsertRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserServiceOut {

    UserDto createOut(UsertRequest usertRequest);

    Optional<UserDto> getOut(Long id);

    List<UserDto> listOut();

    UserDto updateOut(Long id,UsertRequest usertRequest);

    UserDto deleteOut(Long id);

    UserDetailsService userDetailServiceOut();
}
