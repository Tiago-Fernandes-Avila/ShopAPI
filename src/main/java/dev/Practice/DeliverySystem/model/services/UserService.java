package dev.Practice.DeliverySystem.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.Practice.DeliverySystem.model.DTOs.UserFullDTO;
import dev.Practice.DeliverySystem.model.entities.User;
import dev.Practice.DeliverySystem.model.repositories.UserRepository;
import java.util.List;
@Service
public class UserService {
    
    @Autowired
        UserRepository repository;

    

    public List<UserFullDTO> FindAllFullUserDTO(){
        List<User> listUser = repository.findAll();

        return listUser.stream().map(x -> new UserFullDTO(x)).toList();

    } 

}
