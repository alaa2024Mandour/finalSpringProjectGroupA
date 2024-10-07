package com.example.finalSpringProject.finalSpringProject.service;


import com.example.finalSpringProject.finalSpringProject.models.UserDTO;

import java.util.List;

public interface UserServiceInt {
    public UserDTO findUserById(Long id);

    public UserDTO saveUser(UserDTO userDTO);

    public UserDTO updateUser(UserDTO userDTO);

    public UserDTO patchUpdateUser(UserDTO userDTO, Long userId);

    public void deleteUser(Long id);

    public List<UserDTO> findAllUsers();

    public UserDTO findByUserName(String userName);

//    UserDTO assignProjectToUser(UserDTO userDTO, Long projectId);
}

