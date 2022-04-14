package pl.sggw.wzim.course.spring.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.wzim.course.spring.domain.customer.Customer;
import pl.sggw.wzim.course.spring.domain.customer.CustomerRepository;

import java.util.List;
import java.util.Optional;

interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByLogin(String login);
}

@Repository
@RequiredArgsConstructor
class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpa;

    @Override
    public Customer save(Customer customer) {
        return jpa.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Optional<Customer> findByLogin(String login) {
        return jpa.findByLogin(login);
    }

    @Override
    public List<Customer> findAll() {
        return jpa.findAll();
    }

    @Override
    public void clear() {
        jpa.deleteAll();
    }
}
