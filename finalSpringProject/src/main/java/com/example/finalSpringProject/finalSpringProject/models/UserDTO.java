package com.example.finalSpringProject.finalSpringProject.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long Id;
    private String username;
    private String email;
    private String phoneNo;
    private Long sid;
    private String password;
    private String rePassword;
}


