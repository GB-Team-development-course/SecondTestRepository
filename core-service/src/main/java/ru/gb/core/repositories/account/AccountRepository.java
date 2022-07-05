package ru.gb.core.repositories.account;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.core.entities.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByAccountNumber (String AccountNumber);

}
