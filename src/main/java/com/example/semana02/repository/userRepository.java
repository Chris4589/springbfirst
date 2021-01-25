package com.example.semana02.repository;

import com.example.semana02.models.UserClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<UserClass, Long>{
    
}
