package pl.sggw.wzim.course.spring.application.commands;

import lombok.RequiredArgsConstructor;
import pl.sggw.wzim.course.spring.application.dtos.OrderItemDto;
import pl.sggw.wzim.course.spring.application.dtos.ShipmentDto;

import java.util.List;

@RequiredArgsConstructor
public class PlaceOrderCommand {
    public final List<OrderItemDto> items;
    public final ShipmentDto shipment;
}

