package pl.sggw.wzim.course.spring.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.wzim.course.spring.domain.product.Tag;
import pl.sggw.wzim.course.spring.domain.product.TagRepository;

import java.util.List;
import java.util.Optional;

interface TagJpaRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}

@Repository
@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepository {
    private final TagJpaRepository jpa;

    @Override
    public Optional<Tag> findByName(String name) {
        return jpa.findByName(name);
    }

    @Override
    public List<Tag> findAll() {
        return jpa.findAll();
    }
}
