package com.deploy.pratikum1.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddRequest {

    @NotBlank(message = "Name tidak boleh kosong")
    private String name;

    @NotNull(message = "Age tidak boleh kosong")
    @Positive(message = "Age harus lebih dari 0")
    private Integer age;
}