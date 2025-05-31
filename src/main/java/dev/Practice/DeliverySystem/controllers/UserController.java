package dev.Practice.DeliverySystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import dev.Practice.DeliverySystem.model.DTOs.UserFullDTO;

import dev.Practice.DeliverySystem.model.repositories.UserRepository;
import dev.Practice.DeliverySystem.model.services.UserService;

@RestController
@RequestMapping (value="/users")

public class UserController {
    @Autowired
    UserService service;

    @Autowired
    UserRepository userRepository;
    
    @GetMapping
    public ResponseEntity<List<UserFullDTO>> findFullDtos(){
        List<UserFullDTO> uList = service.FindAllFullUserDTO();
      
        return ResponseEntity.ok().body(uList);
        
       
    }
    
    

    

}