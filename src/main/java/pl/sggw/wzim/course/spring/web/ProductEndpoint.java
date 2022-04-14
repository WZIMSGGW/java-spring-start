package pl.sggw.wzim.course.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sggw.wzim.course.spring.application.ProductService;
import pl.sggw.wzim.course.spring.application.dtos.ProductDto;

@Controller
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductEndpoint {

    private ProductService productService;

    @GetMapping
    ResponseEntity<Page<ProductDto>> findFiltered(
        Pageable pageable,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) String tag,
        @RequestParam(required = false) int minimumPrice,
        @RequestParam(required = false) int maximumPrice
    ) {
        var products = productService.findFiltered(pageable, name, category, tag, minimumPrice, maximumPrice);
        return ResponseEntity.ok(products);
    }
}
