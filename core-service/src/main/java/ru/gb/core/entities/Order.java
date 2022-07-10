package ru.gb.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;
import ru.gb.core.enums.Currency;
import ru.gb.core.enums.OrderStatus;
import ru.gb.core.enums.TransferDirection;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * Уникальный идентификатор распоряжения на уровне системы
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    @SequenceGenerator(name = "order_gen", sequenceName = "order_id_seq", allocationSize = 1)
    private Long id;

    /**
     * Уникальный идентификатор распоряжения во внешней системе инициаторе
     */
    @NonNull
    @Column(name = "external_order_guid")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID externalOrderGuid;

    /**
     * Направление перевода
     */
    @NonNull
    @Column(name = "transfer_direction_id")
    private TransferDirection transferDirection;

    /**
     * Номер счета списания
     */
    @NonNull
    @Column(name = "source_account")
    private String sourceAccount;

    /**
     * Номер счета зачисления
     */
    @NonNull
    @Column(name = "target_account")
    private String targetAccount;

    /**
     * Сумма
     */
    @NonNull
    private BigDecimal amount;

    /**
     * 3-х значный код валюты распоряжения
     */
    @NonNull
    @Column(name = "currency_id")
    private Currency currency;


    /**
     * Назначение платежа
     */
    @NonNull
    @Column(name = "payment_purpose")
    private String paymentPurpose;

    /**
     * Дополнительная информация (например текст ошибки распоряжения)
     */
    @Nullable
    @Column(name = "additional_information")
    private String additionalInformation;

    /**
     * Статус распоряжения
     */
    @NonNull
    @Column(name = "order_status_id")
    private OrderStatus orderStatus;

    /**
     * Дата/время начала выполнения распоряжения
     */
    @NonNull
    @Column(name = "execution_start")
    private LocalDateTime executionStart;

    /**
     * Дата/время окончания выполнения распоряжения
     */
    @Nullable
    @Column(name = "execution_end")
    private LocalDateTime executionEnd;

}
