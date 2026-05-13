package za.ac.cput.creditapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.creditapi.domain.CreditApplication;
import za.ac.cput.creditapi.domain.Customer;

import java.util.List;

@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {

    List<CreditApplication> FindByCustomer (Customer customer);
    List<CreditApplication> findByStatus (String status);
}
