package com.example.finalSpringProject.finalSpringProject.repo;

import com.example.finalSpringProject.finalSpringProject.entitys.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepoInt extends JpaRepository<ContactEntity, Long> {
}
