package pl.sggw.wzim.course.spring.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sggw.wzim.course.spring.application.commands.PayForOrderCommand;
import pl.sggw.wzim.course.spring.application.commands.PlaceOrderCommand;
import pl.sggw.wzim.course.spring.application.commands.RegisterCustomerCommand;
import pl.sggw.wzim.course.spring.application.dtos.CustomerDto;
import pl.sggw.wzim.course.spring.application.mappers.OrderMapper;
import pl.sggw.wzim.course.spring.utils.SecurityUtils;
import pl.sggw.wzim.course.spring.domain.customer.Customer;
import pl.sggw.wzim.course.spring.domain.customer.CustomerNotFoundException;
import pl.sggw.wzim.course.spring.domain.customer.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final SecurityUtils securityUtils;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;

    public CustomerDto getCurrentlyLoggedCustomer() {
        return dto(getCurrentCustomer());
    }

    public CustomerDto register(RegisterCustomerCommand command) {
        var newCustomer = Customer.create(
            command.login, command.name, command.surname, command.emailAddress, command.phoneNumber
        );
        return dto(customerRepository.save(newCustomer));
    }

    private CustomerDto dto(Customer customer) {
        return new CustomerDto(
            customer.getId(),
            customer.getLogin(),
            customer.getPersonalData().getName(),
            customer.getPersonalData().getSurname(),
            customer.getPersonalData().getEmailAddress(),
            customer.getPersonalData().getPhoneNumber()
        );
    }

    public Long placeOrder(PlaceOrderCommand command) {
        var customer = getCurrentCustomer();
        var orderId = customer.placeOrder(orderMapper.toDomainObject(command));
        customerRepository.save(customer);
        return orderId;
    }

    private Customer getCurrentCustomer() {
        var loggedUserId = securityUtils.getLoggedUserLogin();
        return customerRepository.findByLogin(loggedUserId)
            .orElseThrow(() -> new CustomerNotFoundException(loggedUserId));
    }

    public void payForOrder(PayForOrderCommand command) {
        var customer = getCurrentCustomer();
        customer.payForOrder(command.orderId);
        customerRepository.save(customer);
    }
}
