package za.ac.cput.creditapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.creditapi.domain.CreditApplication;
import za.ac.cput.creditapi.domain.CreditDecision;

import java.util.Optional;

@Repository
public interface CreditDecisionRepository extends JpaRepository<CreditDecision, Long> {

    Optional<CreditDecision> findByCreditApplication(CreditApplication creditApplication);
    
}
