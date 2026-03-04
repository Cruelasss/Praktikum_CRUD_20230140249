package com.deploy.pratikum1.mapper;

import com.deploy.pratikum1.model.dto.UserDto;
import com.deploy.pratikum1.model.entity.User;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDto toUserDtoData (User user);
}
