package pl.sggw.wzim.course.spring.application.mappers;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import pl.sggw.wzim.course.spring.utils.StreamUtils;
import pl.sggw.wzim.course.spring.application.dtos.OrderItemDto;
import pl.sggw.wzim.course.spring.application.commands.PlaceOrderCommand;
import pl.sggw.wzim.course.spring.application.dtos.ShipmentDto;
import pl.sggw.wzim.course.spring.domain.order.Order;
import pl.sggw.wzim.course.spring.domain.order.OrderItem;
import pl.sggw.wzim.course.spring.domain.customer.PersonalData;
import pl.sggw.wzim.course.spring.domain.product.ProductRepository;
import pl.sggw.wzim.course.spring.domain.shipment.DestinationAddress;
import pl.sggw.wzim.course.spring.domain.shipment.Shipment;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductRepository productRepository;

    public Order toDomainObject(PlaceOrderCommand command) {
        List<OrderItem> items = StreamUtils.map(command.items, this::createOrderItem);
        Shipment shipment = fromDto(command.shipment);
        return Order.create(items, shipment);
    }

    private OrderItem createOrderItem(OrderItemDto orderItemDto) {
        // poprawic
        val product = productRepository.findById(orderItemDto.productId).orElseThrow(NoSuchElementException::new);
        return OrderItem.create(product.getId(), orderItemDto.quantity);
    }

    private Shipment fromDto(ShipmentDto shipment) {
        val personalData = PersonalData.builder()
            .name(shipment.name)
            .surname(shipment.surname)
            .emailAddress(shipment.emailAddress)
            .phoneNumber(shipment.phoneNumber)
            .build();
        val destinationAddress = DestinationAddress.builder()
            .street(shipment.street)
            .homeNumber(shipment.homeNumber)
            .flatNumber(shipment.flatNumber)
            .city(shipment.city)
            .postalCode(shipment.postalCode)
            .country(shipment.country)
            .build();

        return new Shipment(personalData, destinationAddress);
    }
}
