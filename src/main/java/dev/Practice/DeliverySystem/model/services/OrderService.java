package dev.Practice.DeliverySystem.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.Practice.DeliverySystem.model.DTO.OrderFullDTO;
import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.repositories.OrderRepository;
import jakarta.transaction.Transactional;

@Service
public class OrderService {

@Autowired
OrderRepository orderRepository;

    @Transactional
    public List<Order> findAllOrder(){
       List<Order> list = orderRepository.findAll();

      // return list.stream().map(x -> new OrderFullDTO(x)).toList();
       return orderRepository.findAll();
       
    }


}
