package dev.Practice.DeliverySystem.model.entities;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table (name = "tb_payment")
public class Payment {

@Id
@Column(name = "c_id")
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "c_payment_moment")
private Instant paymentMoment;

@OneToOne
@MapsId
@JoinColumn(name = "order_id")
@JsonIgnore
private Order order;


public Payment(){

}

public Payment(Long id, Instant paymentMoment, Order order) {
    this.id = id;
    this.paymentMoment = paymentMoment;
    this.order = order;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Instant getPaymentMoment() {
    return paymentMoment;
}

public void setPaymentMoment(Instant paymentMoment) {
    this.paymentMoment = paymentMoment;
}


public Order getOrder(){
    return this.order;
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
    Payment other = (Payment) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}

public void setOrder(Order order) {
    this.order = order;
}


}
