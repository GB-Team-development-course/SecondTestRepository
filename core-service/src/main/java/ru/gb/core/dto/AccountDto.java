package ru.gb.core.dto;

import ru.gb.core.enums.AccountStatus;
import ru.gb.core.enums.AccountType;
import ru.gb.core.enums.Currency;

import java.time.LocalDateTime;

public class AccountDto {

    private AccountType accountType;
    private String accountNumber;
    private AccountStatus accountStatus;
    private Currency currency;
    private LocalDateTime dtCreated;
    private LocalDateTime dtBlocked;
    private LocalDateTime dtClosed;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDateTime getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(LocalDateTime dtCreated) {
        this.dtCreated = dtCreated;
    }

    public LocalDateTime getDtBlocked() {
        return dtBlocked;
    }

    public void setDtBlocked(LocalDateTime dtBlocked) {
        this.dtBlocked = dtBlocked;
    }

    public LocalDateTime getDtClosed() {
        return dtClosed;
    }

    public void setDtClosed(LocalDateTime dtClosed) {
        this.dtClosed = dtClosed;
    }

    public AccountDto() {
    }

    public AccountDto(AccountType accountType, String accountNumber, AccountStatus accountStatus,
                      Currency currency, LocalDateTime dtCreated, LocalDateTime dtBlocked, LocalDateTime dtClosed) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.currency = currency;
        this.dtCreated = dtCreated;
        this.dtBlocked = dtBlocked;
        this.dtClosed = dtClosed;
    }
}
