package pl.sggw.wzim.course.spring.domain.order;

import lombok.RequiredArgsConstructor;
import pl.sggw.wzim.course.spring.common.DomainEvent;
import pl.sggw.wzim.course.spring.domain.shipment.Shipment;

@RequiredArgsConstructor
public class OrderPaid implements DomainEvent {
    public final Long orderId;
    public final Shipment shipment;
}
