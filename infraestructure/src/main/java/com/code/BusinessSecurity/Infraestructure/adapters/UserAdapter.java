package com.code.BusinessSecurity.Infraestructure.adapters;

import com.code.BusinessSecurity.Infraestructure.dao.RolRepository;
import com.code.BusinessSecurity.Infraestructure.dao.UserRepository;
import com.code.BusinessSecurity.Infraestructure.entity.RolEntity;
import com.code.BusinessSecurity.Infraestructure.entity.UserEntity;
import com.code.BusinessSecurity.Infraestructure.mapper.UserMapper;
import com.code.BusinessSecurity.domain.aggregates.constants.Constant;
import com.code.BusinessSecurity.domain.aggregates.dto.UserDto;
import com.code.BusinessSecurity.domain.aggregates.request.UsertRequest;
import com.code.BusinessSecurity.domain.ports.out.UserServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAdapter implements UserServiceOut {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserDto createOut(UsertRequest usertRequest) {
        UserEntity userEntity = getEntity(usertRequest,0);
        return  UserMapper.fromEntity(userRepository.save(userEntity));
    }

    @Override
    public Optional<UserDto> getOut(Long id) {
        UserDto userDto = UserMapper.fromEntity(userRepository.findById(id).get());
        return Optional.of(userDto);
    }

    @Override
    public List<UserDto> listOut() {
        List<UserDto> dtoList = new ArrayList<>();

        List<UserEntity> entityList = userRepository.findAll();
        for (UserEntity dato : entityList) {
            dtoList.add(UserMapper.fromEntity(dato));
        }

        return dtoList;
    }

    @Override
    public UserDto updateOut(Long id, UsertRequest usertRequest) {
        Optional<UserEntity> codeEntity = userRepository.findById(id);
        if(codeEntity.isPresent()){
            UserEntity user = getEntity(usertRequest, id);
            user.setPassword(codeEntity.get().getPassword());
            user.setCreatedAt(codeEntity.get().getCreatedAt());
            return  UserMapper.fromEntity(userRepository.save(user));
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public UserDto deleteOut(Long id) {
        Optional<UserEntity> datoExtraido = userRepository.findById(id);

        if(datoExtraido.isPresent()){
            datoExtraido.get().setIsActive(false);
            datoExtraido.get().setRejectBy(Constant.USU_ADMIN);
            datoExtraido.get().setRejectAt(getTimestamp());
            return UserMapper.fromEntity(userRepository.save(datoExtraido.get()));
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public UserDetailsService userDetailServiceOut() {
        return null;
    }

    private UserEntity getEntity(UsertRequest usertRequest, long id){

        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(usertRequest.getFirstName());
        userEntity.setLastName(usertRequest.getLastName());
        userEntity.setEmail(usertRequest.getEmail());
        //userEntity.setPassword(usertRequest.getPassword());
        userEntity.setImage(usertRequest.getImage());
        userEntity.setIsActive(Constant.STATUS_ACTIVE);

        /*
        Optional<RolEntity> rolEntity = rolRepository.findById(usertRequest.getIdRol());
        userEntity.setRol(rolEntity.get());
        */

        if(id == 0){
            //userEntity.setCreatedby(Constant.USU_ADMIN);
            userEntity.setPassword(new BCryptPasswordEncoder().encode(usertRequest.getPassword()));
            userEntity.setCreatedAt(getTimestamp());
        }else {
            userEntity.setIdUser(id);
            userEntity.setUpdatedBy(Constant.USU_ADMIN);
            userEntity.setUpdatedAt(getTimestamp());
        }

        return userEntity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }


}
