package pl.sggw.wzim.course.spring.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sggw.wzim.course.spring.domain.product.Category;
import pl.sggw.wzim.course.spring.domain.product.Product;
import pl.sggw.wzim.course.spring.domain.product.Tag;
import pl.sggw.wzim.course.spring.domain.product.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface ProductJpaRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.name = :name AND :category in p.categories AND :tag in p.tags " +
        "AND p.price > :minimumPrice AND p.price < :maximumPrice")
    Page<Product> findFiltered(
        Pageable pageable,
        String name,
        Category category,
        Tag tag,
        int minimumPrice,
        int maximumPrice
    );
}

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository jpa;
    private final EntityManager em;

    @Override
    public Optional<Product> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Page<Product> findFiltered(
        Pageable pageable,
        String name,
        Category category,
        Tag tag,
        int minimumPrice,
        int maximumPrice
    ) {
        //CriteriaBuilder cb = em.getCriteriaBuilder();
        //CriteriaQuery<Product> cq = cb.createQuery(Product.class);
//
        //Root<Product> product = cq.from(Product.class);
        //List<Predicate> predicates = new ArrayList<>();
        //if (name != null) {
        //    predicates.add(cb.equal());
        //}
        //if (category != null) {
        //    predicates.add(cb.in());
        //}
        //if (minimumPrice != 0) {
        //    predicates.add(cb.greaterThanOrEqualTo(product.get("price"), minimumPrice));
        //}
        //if (maximumPrice != 0) {
        //    predicates.add(cb.lessThanOrEqualTo(product.get("price"), maximumPrice));
        //}
        return jpa.findFiltered(pageable, name, category, tag, minimumPrice, maximumPrice);
    }

    @Override
    public List<Product> findAll() {
        return jpa.findAll();
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return jpa.saveAll(products);
    }
}
