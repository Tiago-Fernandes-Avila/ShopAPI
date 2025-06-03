package dev.Practice.DeliverySystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Practice.DeliverySystem.model.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

    
}
