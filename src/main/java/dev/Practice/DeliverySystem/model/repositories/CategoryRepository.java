package dev.Practice.DeliverySystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Practice.DeliverySystem.model.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
