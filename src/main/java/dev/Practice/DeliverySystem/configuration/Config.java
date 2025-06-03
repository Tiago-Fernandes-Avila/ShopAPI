package dev.Practice.DeliverySystem.configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.Practice.DeliverySystem.model.entities.Order;
import dev.Practice.DeliverySystem.model.entities.Payment;
import dev.Practice.DeliverySystem.model.entities.User;
import dev.Practice.DeliverySystem.model.entities.Enums.OrderStatus;
import dev.Practice.DeliverySystem.model.repositories.OrderRepository;
import dev.Practice.DeliverySystem.model.repositories.PaymentRepository;
import dev.Practice.DeliverySystem.model.repositories.UserRepository;
import jakarta.transaction.Transactional;



@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

public static final DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE_TIME;

    @Autowired 
    UserRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception{

        User u1 = new User(null,"Edgar Allan Poe","poe@gmail.com", "poe1234", "(55) 999112223111");
        User u2 = new User(null,"Tiago fernandes Avila","tiago@gmail.com", "1234", "(55) 999112223111");
        User u3 = new User(null,"Antonio Vivaldi", "vivaldi@gmail.com", "winter1234", "(55)13123133123");
            
        Order o1 = new Order(null, LocalDateTime.parse("2019-06-20T19:53:07Z",fmt), OrderStatus.PAID, u1);
        Order o2 = new Order(null, LocalDateTime.parse("2019-06-20T19:53:07Z",fmt), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, LocalDateTime.parse("2019-06-20T19:53:07Z",fmt), OrderStatus.WAITING_PAYMENT, u2);

        Payment p1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
        
            
            repository.saveAll(Arrays.asList(u1,u2,u3));
            orderRepository.saveAll(Arrays.asList(o1,o2,o3)); 
            paymentRepository.saveAll(Arrays.asList(p1));
    }
        
   

    

    

}

