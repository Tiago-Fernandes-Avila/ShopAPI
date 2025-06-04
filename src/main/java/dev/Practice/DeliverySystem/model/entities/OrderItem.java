
package dev.Practice.DeliverySystem.model.entities;

import java.io.Serial;
import java.io.Serializable;

import dev.Practice.DeliverySystem.model.entities.PK.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table (name="tb_order_item")
public class OrderItem implements Serializable{
    @Serial
    private static final Long serialVersionUID = 1L;

@EmbeddedId
private OrderItemPK id;

private Double price;

private Integer quantity;

public OrderItem() {
}

public OrderItem(Order order, Product product, Double price, Integer quantity) {
    id.setOrder(order);
    id.setProduct(product);
    this.price = price;
    this.quantity = quantity;
}

public void setOrder(Order order){
    this.id.setOrder(order);
}
public Order getOrder(){
    return this.id.getOrder();
}

public void setProductId(Product product){
    this.id.setProduct(product);
}
public Product getProduct(){
    return this.id.getProduct();
}

public OrderItemPK getId() {
    return id;
}

public void setId(OrderItemPK id) {
    this.id = id;
}

public Double getPrice() {
    return price;
}

public void setPrice(Double price) {
    this.price = price;
}

public Integer getQuantity() {
    return quantity;
}

public void setQuantity(Integer quantity) {
    this.quantity = quantity;
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
    OrderItem other = (OrderItem) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}



}
