package pl.sggw.wzim.course.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sggw.wzim.course.spring.application.CustomerService;
import pl.sggw.wzim.course.spring.application.commands.PayForOrderCommand;
import pl.sggw.wzim.course.spring.application.commands.PlaceOrderCommand;
import pl.sggw.wzim.course.spring.application.commands.RegisterCustomerCommand;
import pl.sggw.wzim.course.spring.application.dtos.CustomerDto;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerEndpoint {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDto> getCurrentlyLoggedCustomer() {
        return ResponseEntity.ok(customerService.getCurrentlyLoggedCustomer());
    }

    @PostMapping("register")
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody RegisterCustomerCommand command) {
        CustomerDto customer = customerService.register(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PostMapping("orders/place")
    public ResponseEntity<Void> placeOrder(
        @RequestBody PlaceOrderCommand command
    ) {
        customerService.placeOrder(command);
        return ResponseEntity.ok().build();
    }

    @PostMapping("orders/pay")
    public ResponseEntity<Void> payForOrder(@RequestBody PayForOrderCommand command) {
        customerService.payForOrder(command);
        return ResponseEntity.ok().build();
    }
}
