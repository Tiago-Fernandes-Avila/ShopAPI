package dev.Practice.DeliverySystem.model.DTOs;

import org.springframework.beans.BeanUtils;

import dev.Practice.DeliverySystem.model.entities.User;

public class UserFullDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;

   public UserFullDTO( User user){
    //BeanUtils.copyProperties(user, this); serve para copiar objeto inteiro para o dto que seja igual em propriedades.
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.phone = user.getPhone();
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
