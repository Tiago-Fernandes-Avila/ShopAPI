package dev.Practice.DeliverySystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Practice.DeliverySystem.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{


}
