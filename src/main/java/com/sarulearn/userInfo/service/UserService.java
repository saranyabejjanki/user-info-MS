package com.sarulearn.userInfo.service;

import com.sarulearn.userInfo.dto.UserDTO;
import com.sarulearn.userInfo.entity.User;
import com.sarulearn.userInfo.mapper.UserMapper;
import com.sarulearn.userInfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements IUserService
{

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = UserMapper.USER_MAPPER.mapUserDTOToUser(userDTO);
        User savedUser = userRepo.save(user);
        UserDTO userDTObject =null;
        if(Objects.nonNull(savedUser)){
            userDTObject = UserMapper.USER_MAPPER.mapUserToUserDTO(savedUser);
        }

        return userDTObject;
    }

    @Override
    public UserDTO findUserById(Integer userId) {
        Optional<User> user = userRepo.findById(userId);
        UserDTO UserDTO=null;
        if(user.isPresent()){
            UserDTO =UserMapper.USER_MAPPER.mapUserToUserDTO(user.get());
        }
        return UserDTO;

    }
}
