package dev.Practice.DeliverySystem.model.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import dev.Practice.DeliverySystem.model.DTO.UserFullDTO;
import dev.Practice.DeliverySystem.model.entities.User;
import dev.Practice.DeliverySystem.model.repositories.UserRepository;
import dev.Practice.DeliverySystem.model.services.servicesexceptions.DataBaseException;
import dev.Practice.DeliverySystem.model.services.servicesexceptions.ResourceNotFoundException;

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
    if (repository.existsById(id)) {
        try{
        repository.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DataBaseException("error! operation not enable");
        }
    }
    else{
        throw new ResourceNotFoundException(id);
    }
         
  
         
        
       
    }
    @Transactional
    public User UpdateUser(Long id, User obj){
        User entity = null;
        try{
     entity = repository.getReferenceById(id); //chamada para criar um objeto em persistencia 
    updateData(entity, obj);
    return repository.save(entity);
    }

    catch(EntityNotFoundException e){
        throw new ResourceNotFoundException(id);
    }
    
    }

    private User updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

       return entity;
    }
}
