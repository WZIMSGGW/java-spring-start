package pl.sggw.wzim.course.spring.domain.order;

import pl.sggw.wzim.course.spring.domain.shipment.Shipment;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "ORDERZ")
public class Order
{
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    @Embedded
    private Shipment shipment;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public static Order create(List<OrderItem> items, Shipment shipment) {
        return new Order(items, shipment, OrderStatus.SUBMITTED);
    }

    public static Order create() {
        var order = new Order();
        order.setStatus(OrderStatus.SUBMITTED);
        return order;
    }

    protected Order(List<OrderItem> items, Shipment shipment, OrderStatus status) {
        this.items = items;
        this.shipment = shipment;
        this.status = status;
    }

    protected Order() { }

    public Long getId() {
        return id;
    }

    public void sentToDelivery() {
        if (status == OrderStatus.PAID) {
            status = OrderStatus.SENT;
        } else {
            throw new IllegalStateException("Cannot send order that was not yet paid");
        }
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Shipment getShipment() {
    return shipment;
}

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
