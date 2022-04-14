package pl.sggw.wzim.course.spring.application.dtos;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductDto {
    public final long id;
    public final String name;
    public final String description;
    public final double price;
    public final List<String> categories;
    public final List<String> tags;
}
