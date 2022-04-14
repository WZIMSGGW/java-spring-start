package pl.sggw.wzim.course.spring.application;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sggw.wzim.course.spring.application.dtos.ProductDto;
import pl.sggw.wzim.course.spring.application.mappers.ProductMapper;
import pl.sggw.wzim.course.spring.domain.product.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final ProductMapper productMapper;

    public Page<ProductDto> findFiltered(
        Pageable pageable,
        String name,
        String category,
        String tag,
        int minimumPrice,
        int maximumPrice
    ) {
        return Page.empty();
        //val page = productRepository.findFiltered(
        //    pageable,
        //    name,
        //    // porpawic wyjatek rzucanie
        //    categoryRepository.findByName(category).orElseThrow(),
        //    tagRepository.findByName(tag).orElseThrow(),
        //    minimumPrice,
        //    maximumPrice
        //);
        //return page.map(productMapper::toDto);
    }
}
