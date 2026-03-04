package com.deploy.pratikum1.controller;

import com.deploy.pratikum1.model.dto.UserAddRequest;
import com.deploy.pratikum1.model.dto.UserDto;
import com.deploy.pratikum1.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // ===============================
    // CREATE USER
    // ===============================
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> addUser(
            @Valid @RequestBody UserAddRequest request
    ) {

        UserDto result = userService.AddUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "status", "success",
                "message", "User berhasil ditambahkan",
                "data", result
        ));
    }

    // ===============================
    // GET ALL USERS
    // ===============================
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllUser() {

        List<UserDto> result = userService.getAllUser();

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", result
        ));
    }

    // ===============================
    // GET USER BY ID
    // ===============================
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getUserById(
            @PathVariable String id
    ) {

        UserDto result = userService.getUserById(id);

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", result
        ));
    }

    // ===============================
    // UPDATE USER
    // ===============================
    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> updateUser(
            @PathVariable String id,
            @Valid @RequestBody UserAddRequest request
    ) {

        UserDto result = userService.UpdateUser(id, request);

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "User berhasil diperbarui",
                "data", result
        ));
    }

    // ===============================
    // DELETE USER
    // ===============================
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> deleteUser(
            @PathVariable String id
    ) {

        userService.DeleteUser(id);

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "User berhasil dihapus dengan id " + id
        ));
    }
}