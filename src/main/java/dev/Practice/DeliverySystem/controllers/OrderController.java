package dev.Practice.DeliverySystem.controllers;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.repositories.OrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Practice.DeliverySystem.model.DTO.OrderFullDTO;
import dev.Practice.DeliverySystem.model.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService service;
    
    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<Order> getFullOrderDtos() {


        return   service.findAllOrder();
        
        
    }


    
    
}
