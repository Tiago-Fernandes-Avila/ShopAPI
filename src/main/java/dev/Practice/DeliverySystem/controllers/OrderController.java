package dev.Practice.DeliverySystem.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Practice.DeliverySystem.model.DTOs.OrderFullDTO;
import dev.Practice.DeliverySystem.model.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService service;
    
    

    @GetMapping
    public List<OrderFullDTO> getFullOrderDtos() {
    

        return service.findAllOrder();
        
        
    }


    
    
}
