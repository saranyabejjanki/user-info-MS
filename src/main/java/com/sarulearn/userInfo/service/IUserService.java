package com.sarulearn.userInfo.service;


import com.sarulearn.userInfo.dto.UserDTO;




public interface IUserService {

    UserDTO addUser(UserDTO userDTO);

    UserDTO findUserById(Integer userId);
}
