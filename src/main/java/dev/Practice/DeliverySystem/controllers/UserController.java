package dev.Practice.DeliverySystem.controllers;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import dev.Practice.DeliverySystem.model.DTO.UserFullDTO;

import dev.Practice.DeliverySystem.model.repositories.UserRepository;
import dev.Practice.DeliverySystem.model.services.UserService;
import dev.Practice.DeliverySystem.model.services.servicesexceptions.ResourceNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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
    public User findUserFullDTOById(@PathVariable Long id){
          Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> insertUser(@RequestBody User entity) {
        service.insertUser(entity);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(entity.getId())
                                                  .toUri();

        // Retorna o status 201, o corpo com o objeto criado e o cabeçalho Location
        return ResponseEntity.created(location).body(entity);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
       service.deleteUser(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody User entity) {
    entity =  service.UpdateUser(id, entity);
        
        return ResponseEntity.ok().body(entity);
    }




    

}