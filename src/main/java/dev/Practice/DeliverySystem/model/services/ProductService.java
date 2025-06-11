package dev.Practice.DeliverySystem.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.Practice.DeliverySystem.model.DTO.ProductDTO;
import dev.Practice.DeliverySystem.model.entities.Product;
import dev.Practice.DeliverySystem.model.repositories.ProductRepository;


@Service
public class ProductService {
@Autowired
ProductRepository repository;
    
@Transactional
public List<Product> findAll(){
    return repository.findAll();
}

@Transactional 
public Product findByIDProduct(Long id){
    return repository.findById(id).get();
}

@Transactional
public void SaveProduct(ProductDTO productDTO){
    repository.save(new Product(null, productDTO.getName(),productDTO.getPrice(),productDTO.getDesc(),productDTO.getImgUrl()));
}


}
