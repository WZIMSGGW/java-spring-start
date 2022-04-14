package pl.sggw.wzim.course.spring.domain.shipment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.sggw.wzim.course.spring.domain.customer.PersonalData;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Builder
@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @NonNull @Embedded private PersonalData personalData;
    @NonNull @Embedded private DestinationAddress address;
}
