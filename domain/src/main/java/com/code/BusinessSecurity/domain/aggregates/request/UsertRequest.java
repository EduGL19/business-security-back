package com.code.BusinessSecurity.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsertRequest {

    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String image;
    private Long idRol;
    private Boolean isActive;

}
