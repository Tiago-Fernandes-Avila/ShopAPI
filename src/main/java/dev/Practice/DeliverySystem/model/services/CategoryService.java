package dev.Practice.DeliverySystem.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.Practice.DeliverySystem.model.repositories.CategoryRepository;
import dev.Practice.DeliverySystem.model.entities.*;
import java.util.List;
@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;
    
    @Transactional
    public List<Category> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Category findById(Long id){
        return repository.findById(id).get();
    }
}
