package com.deploy.pratikum1.service;

import com.deploy.pratikum1.model.dto.UserAddRequest;
import com.deploy.pratikum1.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto AddUser (UserAddRequest request);
    List<UserDto> getAllUser ();
    UserDto getUserById(String id);
    UserDto UpdaetUser (String id,  UserAddRequest request);
    void DeleteUser(String id);

}
