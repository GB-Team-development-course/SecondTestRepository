package ru.gb.core.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "balances")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_gen")
    @SequenceGenerator(name = "balance_gen", sequenceName = "balance_id_seq", allocationSize = 1)
    private Long id;

    /**
     * Уникальный ID счета на уровне системы.  Используется как ключ для других сущностей системы.
     */
    @JoinColumn(name = "account_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Account account;

    /**
     * Актуальный остаток кредитных средств
     */
    @NonNull
    @Column(name = "credit_balance")
    private BigDecimal creditBalance = BigDecimal.ZERO;

    /**
     * Актуальный остаток собственных средств
     */
    @NonNull
    @Column(name = "debit_balance")
    private BigDecimal debitBalance = BigDecimal.ZERO;

    /**
     * Дата и время последнего обновления информации по счету
     */
    @NonNull
    @Column(name = "dt_last_update")
    private LocalDateTime dtLastUpdate = LocalDateTime.now();

}
