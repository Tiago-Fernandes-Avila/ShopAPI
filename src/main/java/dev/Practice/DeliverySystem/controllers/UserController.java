package dev.Practice.DeliverySystem.controllers;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import dev.Practice.DeliverySystem.model.DTO.UserFullDTO;

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
    public ResponseEntity<List<UserFullDTO>> findAll() {
        List<UserFullDTO> list = service.FindAllFullUserDTO();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping (value = "/{id}")
    public UserFullDTO findUserFullDTOById(@PathVariable Long id){

        return service.findFullDtoById(id);
    }
    
    

    

}