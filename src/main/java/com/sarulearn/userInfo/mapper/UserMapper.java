package com.sarulearn.userInfo.mapper;

import com.sarulearn.userInfo.dto.UserDTO;
import com.sarulearn.userInfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER= Mappers.getMapper(UserMapper.class);

    UserDTO mapUserToUserDTO(User user);
    User mapUserDTOToUser(UserDTO userDTO);
}
