package dev.Practice.DeliverySystem.model.DTO;

import java.time.LocalDateTime;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.entities.User;
import dev.Practice.DeliverySystem.model.entities.Enums.OrderStatus;



public class OrderFullDTO {
    private Long id;
    private LocalDateTime moment;
    private OrderStatus orderStatus;

    public OrderFullDTO (Order order){
        this.id = order.getId();
        this.orderStatus = order.getOrderStatus();
        this.moment = order.getMoment();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }



}
//dto da classe dependente para não dar ruim lá no final