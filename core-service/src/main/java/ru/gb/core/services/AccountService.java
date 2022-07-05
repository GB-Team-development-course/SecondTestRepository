package ru.gb.core.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.core.entities.Account;
import ru.gb.core.repositories.account.AccountRepository;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Optional<Account> findById(String accountNum) {
        return accountRepository.findAccountByAccountNumber(accountNum);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
