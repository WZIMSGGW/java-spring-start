package pl.sggw.wzim.course.spring.domain.order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> findAll();
    Optional<Order> findById(Long orderId);
    Order save(Order order);
}
