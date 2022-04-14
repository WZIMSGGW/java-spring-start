package pl.sggw.wzim.course.spring.domain.product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;

    public Category(String name) {
        this.name = name;
    }

    protected Category() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
