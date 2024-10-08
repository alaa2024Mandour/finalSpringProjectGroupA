package com.example.finalSpringProject.finalSpringProject.controller;

import com.example.finalSpringProject.finalSpringProject.entitys.CustomResponse;
import com.example.finalSpringProject.finalSpringProject.models.ContactDTO;
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
@RequestMapping("/User/view")
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

    //login
    @GetMapping("/login")
    public String login( Model model) {
        model.addAttribute("userList",new UserDTO());
        return "login";
    }

    //about
    @GetMapping("/about")
    public String about( Model model) {
        model.addAttribute("userList",new UserDTO());
        return "about";
    }
    //ContactUs
    @GetMapping("/contact")
    public String contactUs( Model model) {
        model.addAttribute("Contact",new ContactDTO());
        return "contact";
    }
    @PostMapping("/form")
    public String contactUs(ContactDTO contactDTO, Model model) {
        ContactDTO contactDto = userServiceInt.savemessage(contactDTO);
        model.addAttribute("Contact",new ContactDTO());
        return "contact";
    }

    //service
    @GetMapping("/service")
    public String service( Model model) {
        model.addAttribute("userList",new UserDTO());
        return "service";
    }

    //chatbot
    @GetMapping("/chatbot")
    public String chatbot( Model model) {
        model.addAttribute("userList",new UserDTO());
        return "chatbot";
    }

    //index
    @GetMapping("/index")
    public String index( Model model) {
        model.addAttribute("userList",new UserDTO());
        return "index";
    }

    //signUp
    @GetMapping("/signUp")
    public String saveUser(Model model) {
        model.addAttribute("userList",new UserDTO());
        return "signUp";
    }
    @PostMapping
    public String saveUser( UserDTO _userDTO, Model model) {
        UserDTO userDTO = userServiceInt.saveUser(_userDTO);
        model.addAttribute("userList",new UserDTO());
        return "signUp";
    }

    //put
    @PutMapping
    public CustomResponse<UserDTO> updateUser(UserDTO _userDTO) {
        if(_userDTO != null){
            System.out.println("User updated DONE");
        }
        UserDTO userDTO = userServiceInt.updateUser(_userDTO);
        return new CustomResponse<>("01","Success",userDTO);
    }

    //patch
    @PatchMapping
    public ResponseEntity<?> patchUser( UserDTO _userDTO , Long userId) {
        UserDTO userDTO = userServiceInt.patchUpdateUser(_userDTO, userId);
        CustomResponse<UserDTO> customResponse = new CustomResponse<>("01","Success",userDTO);
        return new ResponseEntity<>(customResponse, HttpStatus.ALREADY_REPORTED);
    }

    @DeleteMapping
    public void deleteUserById( Long id) {
        userServiceInt.deleteUser(id);
    }

    @GetMapping("/byName")
    public CustomResponse<UserDTO> findUserByUserName(@RequestParam String userName) {
        UserDTO userDTO = userServiceInt.findByUserName(userName);
        return new CustomResponse<>("01","Success",userDTO);
    }
}
