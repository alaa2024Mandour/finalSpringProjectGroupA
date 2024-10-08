package com.example.finalSpringProject.finalSpringProject.repo;

import com.example.finalSpringProject.finalSpringProject.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepoInt extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntitiesByUsername(String username);

    List<UserEntity> findUserEntitiesByEmail(String email);
}
