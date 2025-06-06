package dev.Practice.DeliverySystem.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbUser")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "cId")
    private Long id;
    @Column (name = "cName")
    private String name;
    @Column (name = "cEmail")
    private String email;
    @Column (name = "cPassword")
    private String password;
    @Column (name = "cPhone")
    private String phone;
    @JsonIgnore
    @OneToMany(mappedBy= "user", cascade = CascadeType.ALL) //cascade para salvar filhos com o pai                 //o que é Fetch type !!!!!
    private List<Order> order = new ArrayList<>(); //um usuario tem varios pedidos
    
    
    
    public User(){

    }
    public User(Long id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public List<Order> getOrder() {
        return  order;
    }



}
