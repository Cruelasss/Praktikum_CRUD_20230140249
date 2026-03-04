package com.deploy.pratikum1.service.lmpl;

import com.deploy.pratikum1.mapper.UserMapper;
import com.deploy.pratikum1.model.dto.UserAddRequest;
import com.deploy.pratikum1.model.dto.UserDto;
import com.deploy.pratikum1.model.entity.User;
import com.deploy.pratikum1.repository.UserRepository;
import com.deploy.pratikum1.service.UserService;
import com.deploy.pratikum1.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Autowired
    private UserMapper userMapper; // ✅ inject mapper

    @Override
    public UserDto AddUser(UserAddRequest request) {

        validationUtil.validate(request);

        User saveUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .age(request.getAge())
                .build();

        userRepository.save(saveUser);

        return userMapper.toUserDtoData(saveUser);
    }

    @Override
    public List<UserDto> getAllUser() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDtoData)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(String id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toUserDtoData(user);
    }

    @Override
    public UserDto UpdaetUser(String id, UserAddRequest request) {
        return null;
    }

    @Override
    public UserDto UpdateUser(String id, UserAddRequest request) {

        validationUtil.validate(request);

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(request.getName());
        existingUser.setAge(request.getAge());

        userRepository.save(existingUser);

        return userMapper.toUserDtoData(existingUser);
    }

    @Override
    public void DeleteUser(String id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}