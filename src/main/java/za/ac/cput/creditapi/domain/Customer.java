package za.ac.cput.creditapi.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String idNumber;

    private BigDecimal monthlyIncome;
    private BigDecimal monthlyExpenses;
    private String employmentStatus;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CreditApplication> creditApplications;

    protected Customer() {
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.idNumber = builder.idNumber;
        this.monthlyIncome = builder.monthlyIncome;
        this.monthlyExpenses = builder.monthlyExpenses;
        this.employmentStatus = builder.employmentStatus;
        this.createdAt = builder.createdAt;
        this.creditApplications = builder.creditApplications;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Generate getters only for now

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String idNumber;
        private BigDecimal monthlyIncome;
        private BigDecimal monthlyExpenses;
        private String employmentStatus;
        private LocalDateTime createdAt;
        private List<CreditApplication> creditApplications;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setIdNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Builder setMonthlyIncome(BigDecimal monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
            return this;
        }

        public Builder setMonthlyExpenses(BigDecimal monthlyExpenses) {
            this.monthlyExpenses = monthlyExpenses;
            return this;
        }

        public Builder setEmploymentStatus(String employmentStatus) {
            this.employmentStatus = employmentStatus;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setCreditApplications(List<CreditApplication> creditApplications) {
            this.creditApplications = creditApplications;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
