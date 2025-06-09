package dev.Practice.DeliverySystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Practice.DeliverySystem.model.entities.OrderItem;
import dev.Practice.DeliverySystem.model.entities.PK.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
