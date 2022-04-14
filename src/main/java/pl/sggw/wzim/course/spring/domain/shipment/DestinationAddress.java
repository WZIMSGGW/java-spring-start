package pl.sggw.wzim.course.spring.domain.shipment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Embeddable;

@Builder
@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DestinationAddress {

    @NonNull private String street;
    @NonNull private Integer homeNumber;
    @Nullable private Integer flatNumber;
    @NonNull private String postalCode;
    @NonNull private String city;
    @NonNull private String country;
}
