package pl.sggw.wzim.course.spring.domain.order;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long productId;

    private int quantity;

    public static OrderItem create(long productId, int quantity) {
        return new OrderItem(productId, quantity);
    }

    public OrderItem(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    protected OrderItem() { }

    public Long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
