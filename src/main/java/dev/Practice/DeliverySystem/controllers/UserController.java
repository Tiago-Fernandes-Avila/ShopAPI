package dev.Practice.DeliverySystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import dev.Practice.DeliverySystem.model.DTOs.UserFullDTO;
import dev.Practice.DeliverySystem.model.services.UserService;

@RestController
@RequestMapping (value="/users")
public class UserController {
    @Autowired
    UserService service;
    
    @GetMapping
    public List<UserFullDTO> findFullDtos(){
        return service.FindAllFullUserDTO();
    }

}