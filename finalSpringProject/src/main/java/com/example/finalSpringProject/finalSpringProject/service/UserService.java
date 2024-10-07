package com.example.finalSpringProject.finalSpringProject.service;
import com.example.finalSpringProject.finalSpringProject.entitys.UserEntity;
import com.example.finalSpringProject.finalSpringProject.exceptions.CustomException;
import com.example.finalSpringProject.finalSpringProject.models.UserDTO;
import com.example.finalSpringProject.finalSpringProject.repo.UserRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInt {

//    private UserEntity mapUserToEntity(UserDTO userDTO) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(userDTO.getId());
//        userEntity.setUsername(userDTO.getUsername());
//        userEntity.setEmail(userDTO.getEmail());
//        userEntity.setPhoneNo(userDTO.getPhoneNo());
//        userEntity.setSid(userDTO.getSid());
//        userEntity.setPassword(userDTO.getPassword());
//        userEntity.setRePassword(userDTO.getRePassword());
//        return userEntity;
//    }
//
//    private UserDTO mapUserToDTO(UserEntity userEntity) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(userEntity.getId());
//        userDTO.setUsername(userEntity.getUsername());
//        userDTO.setPhoneNo(userEntity.getPhoneNo());
//        userDTO.setEmail(userEntity.getEmail());
//        userDTO.setSid(userEntity.getSid());
//        userDTO.setPassword(userEntity.getPassword());
//        userDTO.setRePassword(userEntity.getRePassword());
//        return userDTO;
//    }

    public UserRepoInt userRepoInt;
    public final ModelMapper modelMapper= new ModelMapper();

    UserService(UserRepoInt userRepoInt){
        this.userRepoInt = userRepoInt;
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserEntity userEntity = userRepoInt.findById(id)
                .orElseThrow(
                        () -> new CustomException("not found employee by this id" + id)
                );
        return modelMapper.map(userEntity, UserDTO.class);
    }
    @Override
    public List<UserDTO> findAllUsers() {
        List<UserEntity> userEntities = userRepoInt.findAll();
        return userEntities
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .collect(Collectors.toList());

    }


    @Override
    public UserDTO findByUserName(String userName) {
        UserEntity userEntity = userRepoInt.findUserEntitiesByUsername(userName);
        return modelMapper.map(userEntity, UserDTO.class);
    }



    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity mapedUser = modelMapper.map(userDTO, UserEntity.class);
        UserEntity savedUserEntity = userRepoInt.save(mapedUser);
        return modelMapper.map(savedUserEntity, UserDTO.class);

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity mapedUser = modelMapper.map(userDTO, UserEntity.class);
        UserEntity updatedUserEntity =userRepoInt.save(mapedUser);
        return modelMapper.map(updatedUserEntity, UserDTO.class);
    }

    @Override
    public UserDTO patchUpdateUser(UserDTO userDTO, Long userId) {
        UserEntity oldUserEntity = userRepoInt.findById(userId).get();
        if(userDTO != null){
            if(userDTO.getUsername() != null){
                oldUserEntity.setUsername(userDTO.getUsername());
            }
            if((userDTO.getEmail() != null)){
                oldUserEntity.setEmail(userDTO.getEmail());
            }
            if(userDTO.getPhoneNo() != null){
                oldUserEntity.setPhoneNo(userDTO.getPhoneNo());
            }

        }
        UserEntity patchUpdateUser = userRepoInt.save(oldUserEntity);
        return modelMapper.map(patchUpdateUser, UserDTO.class);

    }

    @Override
    public void deleteUser(Long id) {
        userRepoInt.deleteById(id);
    }
}
