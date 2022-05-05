package pl.sggw.wzim.course.spring.application.commands;

import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@RequiredArgsConstructor
public class RegisterCustomerCommand {
    @NotNull(message = "login cannot be null") @Size(min = 1, max = 100)
    public final String login;

    @NotNull(message = "name cannot be null")
    public final String name;

    @NotNull(message = "surname cannot be null")
    public final String surname;

    @Email(message = "Invalid email format") @NotNull(message = "email address cannot be null")
    public final String emailAddress;

    @NotNull(message = "phone number cannot be null")
    public final String phoneNumber;

    public final LocalDate birthDate;
}
