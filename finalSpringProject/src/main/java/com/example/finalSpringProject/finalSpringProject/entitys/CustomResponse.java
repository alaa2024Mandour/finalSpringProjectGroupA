package com.example.finalSpringProject.finalSpringProject.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse<T> {
    private String code;
    private String message;
    private T data;
}
