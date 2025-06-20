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
    @Transactional
    public User insertUser(User obj){
       return repository.save(obj);
    }

    @Transactional
    public void deleteUser(Long id){ 
        try{
            repository.deleteById(id);
       
        }
        catch(IllegalArgumentException e){
          e.getStackTrace();
          e.getMessage();
        }
    }
    @Transactional
    public User UpdateUser(Long id, User obj){
    User entity = repository.getReferenceById(id);
    updateData(entity, obj);
    return repository.save(entity);
    }

    private User updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

       return entity;
    }
}
