package com.example.finalSpringProject.finalSpringProject.controller;

import com.example.finalSpringProject.finalSpringProject.entitys.CustomResponse;
import com.example.finalSpringProject.finalSpringProject.models.UserDTO;
import com.example.finalSpringProject.finalSpringProject.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String findAllUser (Model model){
        List<UserDTO> UserDTO = userServiceInt.findAllUsers();
        CustomResponse<List<UserDTO>> customResponse = new CustomResponse<>("01","Success",UserDTO);
        model.addAttribute("userList",customResponse);
        return "index";
    }

    @GetMapping
    public String saveUser( Model model) {
        model.addAttribute("userList",new UserDTO());
        return "index";
    }

    @PostMapping
    public String saveUser(UserDTO _userDTO, Model model) {
        UserDTO userDTO = userServiceInt.saveUser(_userDTO);
        model.addAttribute("userList",new UserDTO());
        return "index";
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
