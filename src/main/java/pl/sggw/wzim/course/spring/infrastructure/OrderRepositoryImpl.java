package pl.sggw.wzim.course.spring.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.wzim.course.spring.domain.order.Order;
import pl.sggw.wzim.course.spring.domain.order.OrderRepository;

import java.util.List;
import java.util.Optional;

interface OrderJpaRepository extends JpaRepository<Order, Long> { }

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository jpa;

    @Override
    public Order save(Order order) {
        return jpa.save(order);
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return jpa.findById(orderId);
    }

    @Override
    public List<Order> findAll() {
        return jpa.findAll();
    }
}
