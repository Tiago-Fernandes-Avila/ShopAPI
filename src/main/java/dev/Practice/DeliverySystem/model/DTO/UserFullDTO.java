package dev.Practice.DeliverySystem.model.DTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.entities.User;

public class UserFullDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private List<OrderFullDTO> orders;

    public UserFullDTO (User user){
        this.name = user.getName();

        this.orders =  user.getOrder().stream().map(OrderFullDTO::new).toList();
    }




}
