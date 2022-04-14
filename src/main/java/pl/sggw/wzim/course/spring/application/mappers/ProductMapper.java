package pl.sggw.wzim.course.spring.application.mappers;

import org.springframework.stereotype.Component;
import pl.sggw.wzim.course.spring.application.dtos.ProductDto;
import pl.sggw.wzim.course.spring.domain.product.Category;
import pl.sggw.wzim.course.spring.domain.product.Product;
import pl.sggw.wzim.course.spring.domain.product.Tag;
import pl.sggw.wzim.course.spring.utils.StreamUtils;

import java.math.RoundingMode;

@Component
public class ProductMapper {
    public ProductDto toDto(Product product) {
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice().setScale(2, RoundingMode.HALF_EVEN).doubleValue(),
            StreamUtils.map(product.getCategories(), Category::getName),
            StreamUtils.map(product.getTags(), Tag::getName)
        );
    }
}
