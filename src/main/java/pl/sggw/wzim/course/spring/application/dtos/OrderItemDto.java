package pl.sggw.wzim.course.spring.application.dtos;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderItemDto {
    public final long productId;
    public final int quantity;
}
