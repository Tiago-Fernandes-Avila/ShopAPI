package dev.Practice.DeliverySystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Practice.DeliverySystem.model.DTO.ProductDTO;
import dev.Practice.DeliverySystem.model.entities.Product;
import dev.Practice.DeliverySystem.model.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.findByIDProduct(id);
    }

    @PostMapping("/new")
    public ResponseEntity<ProductDTO> postProduct(@RequestBody ProductDTO entity) {
        
        service.SaveProduct(entity);
        System.out.println("Tudo certo!" + entity);
        return ResponseEntity.ok(entity);
    }
    
    
    

}
