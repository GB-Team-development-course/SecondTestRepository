package ru.gb.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.core.enums.AccountStatus;
import ru.gb.core.enums.AccountType;
import ru.gb.core.enums.Currency;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private AccountType accountType;
    private String accountNumber;
    private AccountStatus accountStatus;
    private Currency currency;
    private LocalDateTime dtCreated;
    private LocalDateTime dtBlocked;
    private LocalDateTime dtClosed;

}
