package dev.Practice.DeliverySystem.model.entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


import dev.Practice.DeliverySystem.model.entities.Enums.OrderStatus;
import jakarta.persistence.*;

@Entity
@Table(name="tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Temporal (TemporalType.TIMESTAMP) //define o tipo de tempo data e hora no db tem outros mais simple
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") //"moment": "2019-06-20T19:53:07","moment": "2019-06-20T19:53:07",
    private LocalDateTime moment;
    @Enumerated(EnumType.STRING)  //transforma em uma enum do tipo string no db  
    private OrderStatus orderStatus;
    
    @ManyToOne
    @JoinColumn(name = "user_id") //declarando a coluna de chave estranjeira e o tipo dela abaixo
    private User user;

 

    @OneToMany (mappedBy = "id.order")
    List<OrderItem> items = new ArrayList<>();
    
    
    
    public List<OrderItem> getItems() {
        return items;
    }


    public void setItems(List<OrderItem> items) {
        this.items = items;
    }


    public Order(){
        
    }
    

    public Order(Long id, LocalDateTime moment, OrderStatus orderStatus, User user) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.user = user;
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
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }





 
    
}
