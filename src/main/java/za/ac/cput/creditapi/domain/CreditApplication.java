package za.ac.cput.creditapi.domain;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal requestedAmount;
    private Integer loanTermMonths;
    private String purpose;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "creditApplication", cascade = CascadeType.ALL)
    private CreditDecision creditDecision;

    protected CreditApplication() {
    }

    private CreditApplication(Builder builder) {
        this.id = builder.id;
        this.requestedAmount = builder.requestedAmount;
        this.loanTermMonths = builder.loanTermMonths;
        this.purpose = builder.purpose;
        this.status = builder.status;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.customer = builder.customer;
        this.creditDecision = builder.creditDecision;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        if (this.status == null) {
            this.status = "PENDING";
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Generate getters only for now

    public static class Builder {
        private Long id;
        private BigDecimal requestedAmount;
        private Integer loanTermMonths;
        private String purpose;
        private String status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Customer customer;
        private CreditDecision creditDecision;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setRequestedAmount(BigDecimal requestedAmount) {
            this.requestedAmount = requestedAmount;
            return this;
        }

        public Builder setLoanTermMonths(Integer loanTermMonths) {
            this.loanTermMonths = loanTermMonths;
            return this;
        }

        public Builder setPurpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setCreditDecision(CreditDecision creditDecision) {
            this.creditDecision = creditDecision;
            return this;
        }

        public CreditApplication build() {
            return new CreditApplication(this);
        }
    }
}