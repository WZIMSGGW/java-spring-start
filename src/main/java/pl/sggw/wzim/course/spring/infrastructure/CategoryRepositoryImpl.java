package pl.sggw.wzim.course.spring.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.wzim.course.spring.domain.product.Category;
import pl.sggw.wzim.course.spring.domain.product.CategoryRepository;

import java.util.List;
import java.util.Optional;

interface CategoryJpaRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryJpaRepository jpa;

    @Override
    public List<Category> findAll() {
        return jpa.findAll();
    }

    @Override
    public Optional<Category> findByName(String name) {
        return jpa.findByName(name);
    }
}
