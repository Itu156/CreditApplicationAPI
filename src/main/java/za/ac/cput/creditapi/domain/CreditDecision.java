package za.ac.cput.creditapi.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class CreditDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String decisionStatus;
    private BigDecimal approvedAmount;
    private BigDecimal interestRate;
    private String reason;
    private String riskLevel;
    private LocalDateTime decisionDate;

    @OneToOne
    @JoinColumn(name = "credit_application_id")
    private CreditApplication creditApplication;

    protected CreditDecision() {
    }

    private CreditDecision(Builder builder) {
        this.id = builder.id;
        this.decisionStatus = builder.decisionStatus;
        this.approvedAmount = builder.approvedAmount;
        this.interestRate = builder.interestRate;
        this.reason = builder.reason;
        this.riskLevel = builder.riskLevel;
        this.decisionDate = builder.decisionDate;
        this.creditApplication = builder.creditApplication;
    }

    @PrePersist
    protected void onCreate() {
        this.decisionDate = LocalDateTime.now();
    }

    // Generate getters only for now

    public static class Builder {
        private Long id;
        private String decisionStatus;
        private BigDecimal approvedAmount;
        private BigDecimal interestRate;
        private String reason;
        private String riskLevel;
        private LocalDateTime decisionDate;
        private CreditApplication creditApplication;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setDecisionStatus(String decisionStatus) {
            this.decisionStatus = decisionStatus;
            return this;
        }

        public Builder setApprovedAmount(BigDecimal approvedAmount) {
            this.approvedAmount = approvedAmount;
            return this;
        }

        public Builder setInterestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder setRiskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
            return this;
        }

        public Builder setDecisionDate(LocalDateTime decisionDate) {
            this.decisionDate = decisionDate;
            return this;
        }

        public Builder setCreditApplication(CreditApplication creditApplication) {
            this.creditApplication = creditApplication;
            return this;
        }

        public CreditDecision build() {
            return new CreditDecision(this);
        }
    }
}
