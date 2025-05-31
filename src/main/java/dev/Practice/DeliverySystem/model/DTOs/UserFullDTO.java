package dev.Practice.DeliverySystem.model.DTOs;

import java.util.List;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.entities.User;

public class UserFullDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private List<Order> orders;



   public UserFullDTO(User user){
    //BeanUtils.copyProperties(user, this); serve para copiar objeto inteiro para o dto que seja igual em propriedades.
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.phone = user.getPhone();
    this.orders = user.getOrder();
   }

   public void setId(Long id) {
    this.id = id;
}

   public void setName(String name) {
    this.name = name;
   }

   public void setEmail(String email) {
    this.email = email;
   }

   public void setPassword(String password) {
    this.password = password;
   }

   public void setPhone(String phone) {
    this.phone = phone;
   }

   public List<Order> getOrders() {
    return this.orders;
   }

   public void setOrders(List<Order> orders) {
    this.orders = orders;
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

   
}
