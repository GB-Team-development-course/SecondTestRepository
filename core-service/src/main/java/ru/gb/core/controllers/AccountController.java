package ru.gb.core.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.core.converters.AccountConverter;
import ru.gb.core.dto.AccountDto;
import ru.gb.core.services.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountConverter accountConverter;

    @GetMapping("/{accountNum}")
    public AccountDto findByAccountNumber(@PathVariable String accountNum) {
        //todo дописать exceptions, пока тут будет заглушка
        return accountConverter.entityToDto(accountService
                .findById(accountNum)
                .orElseThrow(() -> new RuntimeException("Счёт не найден")));
    }

    @GetMapping("/")
    public List<AccountDto> findAll() {
        return accountService.findAll()
                .stream()
                .map(accountConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/createCredit")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCreditAccount() {
        //todo создать новый кредитный счёт,пока заглушка,
        // передавать для создания ничего не надо, будем обрабатывать по внутренней логике
    }

    @PostMapping("/createDebit")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDebitAccount() {
        //todo создать новый дебетовый счёт,пока заглушка,
        // передавать для создания ничего не надо, будем обрабатывать по внутренней логике
    }

}
