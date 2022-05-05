package pl.sggw.wzim.course.spring.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalData {
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private LocalDate birthDate;
}
