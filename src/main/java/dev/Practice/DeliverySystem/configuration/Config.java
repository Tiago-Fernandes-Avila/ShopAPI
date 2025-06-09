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
import dev.Practice.DeliverySystem.model.entities.OrderItem;
import dev.Practice.DeliverySystem.model.entities.Payment;
import dev.Practice.DeliverySystem.model.entities.Product;
import dev.Practice.DeliverySystem.model.entities.User;
import dev.Practice.DeliverySystem.model.entities.Enums.OrderStatus;
import dev.Practice.DeliverySystem.model.repositories.CategoryRepository;
import dev.Practice.DeliverySystem.model.repositories.OrderItemRepository;
import dev.Practice.DeliverySystem.model.repositories.OrderRepository;
import dev.Practice.DeliverySystem.model.repositories.PaymentRepository;
import dev.Practice.DeliverySystem.model.repositories.ProductRepository;
import dev.Practice.DeliverySystem.model.repositories.UserRepository;
import jakarta.transaction.Transactional;
import dev.Practice.DeliverySystem.model.entities.Category;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

public static final DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE_TIME;

    @Autowired
    ProductRepository productRepository;

    @Autowired 
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception{
		Product prod1 = new Product(null, "The Lord of the Rings", 90.0,"Lorem ipsum dolor sit amet, consectetur.", "");
		Product prod2 = new Product(null, "Smart TV", 1500.0,"Nulla eu imperdiet purus. Maecenas ante.", "");
		Product prod3 = new Product(null, "Macbook Pro", 1250.0,"Nam eleifend maximus tortor, at mollis.", "");
		Product prod4 = new Product(null, "PC Gamer",1200.0 ,"Donec aliquet odio ac rhoncus cursus.", "");
		Product prod5 = new Product(null, "Rails for Dummies", 100.99,"Cras fringilla convallis sem vel faucibus.", "");
        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));

        Category c1 = new Category(null, "books");
        Category c2 = new Category(null, "Eletronics");
        Category c3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        //adicionando a tabela de relacionamento das categorias de produtos N:N
        c1.getProducts().addAll(Arrays.asList(prod1, prod5));
        c2.getProducts().addAll(Arrays.asList(prod2));
        c3.getProducts().addAll(Arrays.asList(prod3, prod4));
       categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
      

        User u1 = new User(null,"Edgar Allan Poe","poe@gmail.com", "poe1234", "(55) 999112223111");
        User u2 = new User(null,"Tiago fernandes Avila","tiago@gmail.com", "1234", "(55) 999112223111");
        User u3 = new User(null,"Antonio Vivaldi", "vivaldi@gmail.com", "winter1234", "(55)13123133123");
            userRepository.saveAll(Arrays.asList(u1,u2,u3));
        Order o1 = new Order(null, LocalDateTime.parse("2019-06-20T19:53:07Z",fmt), OrderStatus.PAID, u1);
        Order o2 = new Order(null, LocalDateTime.parse("2019-06-20T19:53:07Z",fmt), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, LocalDateTime.parse("2019-06-20T19:53:07Z",fmt), OrderStatus.WAITING_PAYMENT, u2);
            orderRepository.saveAll(Arrays.asList(o1,o2,o3)); 
        
        
            OrderItem orderItem1 = new OrderItem(o1, prod5, prod5.getPrice(), 1);
            OrderItem orderItem2 = new OrderItem(o1, prod1, prod1.getPrice(),1);
            OrderItem orderItem3 = new OrderItem(o2, prod2, prod2.getPrice(), 1);
            OrderItem orderItem4 = new OrderItem(o2, prod4, prod4.getPrice(), 5);
            OrderItem orderItem5 = new OrderItem(o3, prod3, prod3.getPrice(), 1);
        
            orderItemRepository.saveAll(Arrays.asList(orderItem1,orderItem2,orderItem3,orderItem4,orderItem5));

            
           
        
    }
        
   

    

    

}

