package com.example.finalSpringProject.finalSpringProject.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private Long Id;
    private String username;
    private String email;
    private String subject;
    private String message;
}
