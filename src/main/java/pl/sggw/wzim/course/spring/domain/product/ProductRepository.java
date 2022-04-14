package pl.sggw.wzim.course.spring.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    Page<Product> findFiltered(
        Pageable pageable,
        String name,
        Category category,
        Tag tag,
        int minimumPrice,
        int maximumPrice
    );

    List<Product> saveAll(List<Product> products);
}
