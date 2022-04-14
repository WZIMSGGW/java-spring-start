package pl.sggw.wzim.course.spring.domain.product;

import java.util.List;
import java.util.Optional;

public interface TagRepository {
    List<Tag> findAll();
    Optional<Tag> findByName(String name);
}
