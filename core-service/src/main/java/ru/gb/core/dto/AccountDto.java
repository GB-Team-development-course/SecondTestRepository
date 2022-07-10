package ru.gb.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.core.enums.AccountStatus;
import ru.gb.core.enums.AccountType;
import ru.gb.core.enums.Currency;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Модель счёта")
public class AccountDto {

    @Schema(description = "Тип счёта", required = true, example = "С")
    private AccountType accountType;
    @Schema(description = "Номер счёта", required = true, example = "С1234")
    private String accountNumber;
    @Schema(description = "Статус счёта", required = true, example = "ACTIVE")
    private AccountStatus accountStatus;
    @Schema(description = "Валюта", required = true, example = "USD")
    private Currency currency;
    @Schema(description = "Дата и время создания счёта", required = true)
    private LocalDateTime dtCreated;
    @Schema(description = "Дата и время блокировки счёта")
    private LocalDateTime dtBlocked;
    @Schema(description = "Дата и время закрытия счёта")
    private LocalDateTime dtClosed;

}
