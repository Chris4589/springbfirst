package com.example.semana02.controllers;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import com.example.semana02.dto.ResponseMessage;
import com.example.semana02.models.User;
import com.example.semana02.models.UserClass;
import com.example.semana02.services.KeycloakService;
import com.example.semana02.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService __usService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserClass user){
        return ResponseEntity.status(HttpStatus.CREATED).body(__usService.save(user));
    }
    @GetMapping
    public ResponseEntity<?> read(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(__usService.findAll());
    }
    @GetMapping("/{id}")
    @RolesAllowed("user-backend")
    public ResponseEntity<?> readById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(__usService.findById(id));
    }
    @DeleteMapping("/{id}")
    @RolesAllowed("admin-backend")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        __usService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserClass user){
        
        Optional<UserClass> users = __usService.findById(id);

        users.get().setName(user.getName());
        users.get().setLastname(user.getLastname());

        return ResponseEntity.status(HttpStatus.CREATED).body(__usService.save(users.get()));
    }

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody User user){
        Object[] obj = keycloakService.createUser(user);
        int status = (int) obj[0]; 
        ResponseMessage message = (ResponseMessage) obj[1];
        return ResponseEntity.status(status).body(message);
    }
}
