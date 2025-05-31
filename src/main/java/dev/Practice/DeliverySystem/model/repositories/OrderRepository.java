package dev.Practice.DeliverySystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Practice.DeliverySystem.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
