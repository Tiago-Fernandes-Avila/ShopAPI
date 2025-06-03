package dev.Practice.DeliverySystem.model.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.Practice.DeliverySystem.model.DTO.UserFullDTO;
import dev.Practice.DeliverySystem.model.entities.User;
import dev.Practice.DeliverySystem.model.repositories.UserRepository;
import java.util.List;
@Service
public class UserService {
    
    @Autowired
        UserRepository repository;

    
@Transactional
    public List<UserFullDTO> FindAllFullUserDTO(){
        List<User> listUser = repository.findAll();
     List<UserFullDTO> userFullDTO = listUser.stream().map(UserFullDTO::new).toList();
        return userFullDTO;

    } 

    @Transactional 
    public UserFullDTO findFullDtoById(Long id){
        UserFullDTO uDto = new UserFullDTO(repository.findById(id).get());
        return uDto;

    }

}
