package com.code.BusinessSecurity.application.controller;

import com.code.BusinessSecurity.domain.aggregates.dto.UserDto;
import com.code.BusinessSecurity.domain.aggregates.request.UsertRequest;
import com.code.BusinessSecurity.domain.ports.in.UserServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BusinessSecurity/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserServiceIn userServiceIn;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UsertRequest usertRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userServiceIn.createIn(usertRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userServiceIn.getIn(id).get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> list(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userServiceIn.listIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id,@RequestBody UsertRequest usertRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userServiceIn.updateIn(id,usertRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userServiceIn.deleteIn(id));
    }


}
