package dev.Practice.DeliverySystem.model.DTOs;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.entities.User;
import dev.Practice.DeliverySystem.model.entities.Enums.OrderStatus;



public class OrderFullDTO {
    private Long id;
    private LocalDateTime moment;
    private OrderStatus orderStatus;
    private User user;

    public OrderFullDTO(Order order){
        this.id = order.getId();
        this.moment = order.getMoment();
        this.orderStatus = order.getOrderStatus();
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
