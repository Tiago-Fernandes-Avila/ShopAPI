package dev.Practice.DeliverySystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Practice.DeliverySystem.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
