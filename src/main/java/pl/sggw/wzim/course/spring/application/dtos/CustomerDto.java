package pl.sggw.wzim.course.spring.application.dtos;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerDto {
    public final long id;
    public final String login;
    public final String name;
    public final String surname;
    public final String emailAddress;
    public final String phoneNumber;
}
