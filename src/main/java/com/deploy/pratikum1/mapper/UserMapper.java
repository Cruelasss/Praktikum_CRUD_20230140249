package com.deploy.pratikum1.mapper;

import com.deploy.pratikum1.model.dto.UserDto;
import com.deploy.pratikum1.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDtoData(User user);

    User toEntity(UserDto userDto);
}