package com.example.semana02.services;

import java.util.Optional;

import com.example.semana02.models.UserClass;
import com.example.semana02.repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserClassService implements UserService {

    @Autowired
    private userRepository userrepo;

    @Override
    @Transactional(readOnly = true)
    public Iterable<UserClass> findAll() {
        return userrepo.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<UserClass> findById(Long id) {
        
        return userrepo.findById(id);
    }

    @Override
    @Transactional
    public UserClass save(UserClass user) {
        
        return userrepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userrepo.deleteById(id);

    }

    
}
