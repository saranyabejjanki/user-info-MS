package com.sarulearn.userInfo.controller;

import com.sarulearn.userInfo.dto.UserDTO;
import com.sarulearn.userInfo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping(path ="/saveUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
         UserDTO savedUserDTO =userService.addUser(userDTO);

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        if(Objects.nonNull(savedUserDTO)){
            httpStatus = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(savedUserDTO,httpStatus);

    }

    @GetMapping(path ="/user/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Integer userId){
        UserDTO userDTO = userService.findUserById(userId);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        if(Objects.nonNull(userDTO)){
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(userDTO,httpStatus);
    }

}
