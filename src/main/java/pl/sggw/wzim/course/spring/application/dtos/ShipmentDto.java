package pl.sggw.wzim.course.spring.application.dtos;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class ShipmentDto {
    public final String name;
    public final String surname;
    public final String emailAddress;
    public final String phoneNumber;

    public final String street;
    public final int homeNumber;
    public final int flatNumber;
    public final String postalCode;
    public final String city;
    public final String country;
}

