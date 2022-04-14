package pl.sggw.wzim.course.spring.domain.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

    Optional<Customer> findByLogin(String login);

    List<Customer> findAll();

    void clear();
}
