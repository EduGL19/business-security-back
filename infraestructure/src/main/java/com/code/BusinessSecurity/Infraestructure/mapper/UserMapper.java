package com.code.BusinessSecurity.Infraestructure.mapper;

import com.code.BusinessSecurity.Infraestructure.entity.UserEntity;
import com.code.BusinessSecurity.domain.aggregates.dto.UserDto;

public class UserMapper {

    public static UserDto fromEntity(UserEntity userEntity){

        UserDto userDto = new UserDto();
        userDto.setIdUser(userEntity.getIdUser());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setImage(userEntity.getImage());
        userDto.setIsActive(userEntity.getIsActive());
        //userDto.setIdRol(userEntity.getRolEntity().getIdRol());

        return  userDto;

    }

}
