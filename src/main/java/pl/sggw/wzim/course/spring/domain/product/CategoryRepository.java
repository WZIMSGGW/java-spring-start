package pl.sggw.wzim.course.spring.domain.product;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> findAll();
    Optional<Category> findByName(String name);
}
