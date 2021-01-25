package com.example.semana02.services;

import java.util.Optional;

import com.example.semana02.models.UserClass;


public interface UserService {
    public Iterable<UserClass> findAll();

    public Optional<UserClass> findById(Long id);

    public UserClass save( UserClass user );

    public void deleteById(Long id);

    

}
