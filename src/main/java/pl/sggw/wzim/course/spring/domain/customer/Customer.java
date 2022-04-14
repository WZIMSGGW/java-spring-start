package pl.sggw.wzim.course.spring.domain.customer;

import org.springframework.data.domain.AbstractAggregateRoot;
import pl.sggw.wzim.course.spring.domain.order.Order;
import pl.sggw.wzim.course.spring.domain.order.OrderPaid;
import pl.sggw.wzim.course.spring.domain.order.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends AbstractAggregateRoot<Customer> {

    @Id
    @GeneratedValue
    private long id;

    private String login;

    @Embedded
    private PersonalData personalData;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<Order> orders;

    public static Customer create(
        String login, String name, String surname, String emailAddress, String phoneNumber
    ) {
        return new Customer(
            login,
            new PersonalData(name, surname, emailAddress, phoneNumber),
            new ArrayList<>()
        );
    }

    public Customer(String login, PersonalData personalData, List<Order> orders) {
        this.login = login;
        this.personalData = personalData;
        this.orders = orders;
    }

    public Customer() { }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Long placeOrder(Order order) {
        orders.add(order);
        return order.getId();
    }

    public void payForOrder(long orderId) {
        Order order = orders
            .stream()
            .filter(o -> o.getId().equals(orderId))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Order with id: " + orderId + " not found"));
        order.setStatus(OrderStatus.PAID);
        registerEvent(new OrderPaid(order.getId(), order.getShipment()));
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
