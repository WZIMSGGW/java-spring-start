package pl.sggw.wzim.course.spring.domain.product;

import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "Product")
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "product_category",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "product_tag",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    public Product(String name, String description, BigDecimal price, Set<Category> categories, Set<Tag> tags) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categories = categories;
        this.tags = tags;
    }

    protected Product() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<Tag> getTags() {
        return tags;
    }
}
