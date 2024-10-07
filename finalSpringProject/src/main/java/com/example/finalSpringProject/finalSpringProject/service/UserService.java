package com.example.finalSpringProject.finalSpringProject.service;
import com.example.finalSpringProject.finalSpringProject.entitys.UserEntity;
import com.example.finalSpringProject.finalSpringProject.exceptions.CustomException;
import com.example.finalSpringProject.finalSpringProject.models.UserDTO;
import com.example.finalSpringProject.finalSpringProject.repo.UserRepoInt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInt {

    private UserEntity mapUserToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhoneNo(userDTO.getPhoneNo());
        userEntity.setSid(userDTO.getSid());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRePassword(userDTO.getRePassword());
        return userEntity;
    }

    private UserDTO mapUserToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPhoneNo(userEntity.getPhoneNo());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setSid(userEntity.getSid());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setRePassword(userEntity.getRePassword());
        return userDTO;
    }

    public UserRepoInt userRepoInt;


    @Override
    public UserDTO findUserById(Long id) {
        UserEntity userEntity = userRepoInt.findById(id)
                .orElseThrow(
                        () -> new CustomException("not found employee by this id" + id)
                );
        return mapUserToDTO(userEntity);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserEntity> userEntities = userRepoInt.findAll();
        return userEntities
                .stream()
                .map(userEntity -> mapUserToDTO(userEntity))
                .collect(Collectors.toList());

    }


    @Override
    public UserDTO findByUserName(String userName) {
        UserEntity userEntity = userRepoInt.findUserEntitiesByUsername(userName);
        return mapUserToDTO(userEntity);
    }


    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity mapedUser = mapUserToEntity(userDTO);
        UserEntity savedUserEntity = userRepoInt.save(mapedUser);
        return mapUserToDTO(savedUserEntity);

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity mapedUser = mapUserToEntity(userDTO);
        UserEntity updatedUserEntity =userRepoInt.save(mapedUser);
        return mapUserToDTO(updatedUserEntity);
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
        return mapUserToDTO(patchUpdateUser);

    }

    @Override
    public void deleteUser(Long id) {
        userRepoInt.deleteById(id);
    }
}
