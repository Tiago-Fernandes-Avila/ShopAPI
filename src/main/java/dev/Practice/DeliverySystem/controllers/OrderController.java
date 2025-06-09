package dev.Practice.DeliverySystem.controllers;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.repositories.OrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Practice.DeliverySystem.model.DTO.OrderFullDTO;
import dev.Practice.DeliverySystem.model.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService service;
    
    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<OrderFullDTO> getFullOrderDtos() {
        return service.findAllOrder();
    }
    @GetMapping("/{id}")
    public Order getDtoById(@PathVariable Long id){
       return orderRepository.findById(id).get();
    }

    
    
}
