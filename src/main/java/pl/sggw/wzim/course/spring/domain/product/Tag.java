package pl.sggw.wzim.course.spring.domain.product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Product> products;

    public Tag(String name) {
        this.name = name;
    }

    protected Tag() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
