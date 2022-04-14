package pl.sggw.wzim.course.spring.application;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.sggw.wzim.course.spring.domain.order.Order;
import pl.sggw.wzim.course.spring.domain.order.OrderPaid;
import pl.sggw.wzim.course.spring.domain.order.OrderRepository;

import java.util.*;

@Component
@RequiredArgsConstructor
public class OrderHandler {

    private final OrderRepository orderRepository;

    private Queue<OrderPaid> ordersPendingToSent = new LinkedList<>();

    @EventListener
    public void handle(OrderPaid event) {
        synchronized (this) {
            ordersPendingToSent.offer(event);
        }
    }

    @Scheduled(initialDelay = 60_000, fixedDelay = 3_600_000L)
    public void sendOrders() {
        synchronized (this) {
            while (!ordersPendingToSent.isEmpty()) {
                OrderPaid awaitingOrder = ordersPendingToSent.poll();
                Optional<Order> order = orderRepository.findById(awaitingOrder.orderId);
                order.ifPresent(o -> {
                    o.sentToDelivery();
                    orderRepository.save(o);
                });
            }
        }
    }
}
