package pl.sggw.wzim.course.spring.domain.customer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String customerId) {
        super("Customer with id: " + customerId + " was not found", null);
    }
}
