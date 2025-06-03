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
        this.id = user.getId();
        this.email = user.getEmail();
        this.password= user.getPassword();
        this.phone = user.getPhone();

        this.orders =  user.getOrder().stream().map(OrderFullDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public List<OrderFullDTO> getOrders() {
        return orders;
    }

    



}
