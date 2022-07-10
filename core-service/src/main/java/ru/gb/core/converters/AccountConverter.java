package ru.gb.core.converters;

import org.springframework.stereotype.Component;
import ru.gb.core.dto.AccountDto;
import ru.gb.core.entities.Account;

@Component
public class AccountConverter {

        public Account dtoToEntity(AccountDto accountDto) {
            throw new UnsupportedOperationException();
        }

        public AccountDto entityToDto(Account account) {
            AccountDto out = new AccountDto();
            out.setAccountStatus(account.getAccountStatus());
            out.setAccountNumber(account.getAccountNumber());
            out.setAccountType(account.getAccountType());
            out.setCurrency(account.getCurrency());
            out.setDtBlocked(account.getDtBlocked());
            out.setDtClosed(account.getDtClosed());
            out.setDtCreated(account.getDtCreated());
            return out;
        }
    }

