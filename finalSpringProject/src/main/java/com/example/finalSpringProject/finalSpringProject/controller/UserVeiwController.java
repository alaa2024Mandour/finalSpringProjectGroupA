package com.example.finalSpringProject.finalSpringProject.controller;

import com.example.finalSpringProject.finalSpringProject.entitys.CustomResponse;
import com.example.finalSpringProject.finalSpringProject.models.UserDTO;
import com.example.finalSpringProject.finalSpringProject.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/User")
public class UserVeiwController {
    private final UserServiceInt userServiceInt;

    @Autowired
    UserVeiwController(UserServiceInt userServiceInt) {
        this.userServiceInt = userServiceInt;
    }

    @GetMapping("/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam  Long id){
        UserDTO userDTO = userServiceInt.findUserById(id);
        CustomResponse<UserDTO> customResponse =new CustomResponse<>("01","Success",userDTO);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
    @GetMapping("/getUserByName")
    public ResponseEntity<?> findByUserName(@RequestParam String name){
        UserDTO userDTO = userServiceInt.findByUserName(name);
        CustomResponse<UserDTO> customResponse =new CustomResponse<>("01","Success",userDTO);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAllUser (){
        List<UserDTO> UserDTO = userServiceInt.findAllUsers();
        CustomResponse<List<UserDTO>> customResponse = new CustomResponse<>("01","Success",UserDTO);
        return  new  ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @PostMapping
    public String saveUser(@RequestBody UserDTO _userDTO) {
        UserDTO userDTO = userServiceInt.saveUser(_userDTO);
        CustomResponse<UserDTO> customResponse = new CustomResponse<>("01","Success",userDTO);
        return "";
    }

    @PostMapping
    public CustomResponse<UserDTO> saveUser(@RequestBody UserDTO _userDTO) {
        UserDTO userDTO = userServiceInt.saveUser(_userDTO);
        return new CustomResponse<>("01","Success",userDTO);
    }

    @PutMapping
    public CustomResponse<UserDTO> updateUser(@RequestBody UserDTO _userDTO) {
        if(_userDTO != null){
            System.out.println("User updated DONE");
        }
        UserDTO userDTO = userServiceInt.updateUser(_userDTO);
        return new CustomResponse<>("01","Success",userDTO);
    }

    @PatchMapping
    public ResponseEntity<?> patchUser(@RequestBody UserDTO _userDTO , @RequestParam Long userId) {
        UserDTO userDTO = userServiceInt.patchUpdateUser(_userDTO, userId);
        CustomResponse<UserDTO> customResponse = new CustomResponse<>("01","Success",userDTO);
        return new ResponseEntity<>(customResponse, HttpStatus.ALREADY_REPORTED);
    }

    @DeleteMapping
    public void deleteUserById(@RequestParam Long id) {
        userServiceInt.deleteUser(id);
    }

    @GetMapping("/byName")
    public CustomResponse<UserDTO> findUserByUserName(@RequestParam String userName) {
        UserDTO userDTO = userServiceInt.findByUserName(userName);
        return new CustomResponse<>("01","Success",userDTO);
    }
}
