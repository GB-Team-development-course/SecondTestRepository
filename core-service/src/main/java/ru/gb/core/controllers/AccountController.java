package ru.gb.core.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Счета", description = "Методы работы со счетами")
public class AccountController {

    private final AccountService accountService;
    private final AccountConverter accountConverter;

    @Operation(
            summary = "Запрос на получение счёта по номеру",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AccountDto.class))
                    )
            }
    )
    @GetMapping("/{accountNum}")
    public AccountDto findByAccountNumber(@PathVariable @Parameter(description = "Номер счёта", required = true) String accountNum) {
        //todo дописать exceptions, пока тут будет заглушка
        return accountConverter.entityToDto(accountService
                .findById(accountNum)
                .orElseThrow(() -> new RuntimeException("Счёт не найден")));
    }
    @Operation(
            summary = "Запрос на получение всех счетов",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = List.class))
                    )
            }
    )
    @GetMapping("/")
    public List<AccountDto> findAll() {
        return accountService.findAll()
                .stream()
                .map(accountConverter::entityToDto)
                .collect(Collectors.toList());
    }
    @Operation(
            summary = "Запрос на создание кредитного счёта",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
    @PostMapping("/createCredit")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCreditAccount() {
        //todo создать новый кредитный счёт,пока заглушка,
        // передавать для создания ничего не надо, будем обрабатывать по внутренней логике
    }

    @Operation(
            summary = "Запрос на создание дебетового счёта",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
    @PostMapping("/createDebit")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDebitAccount() {
        //todo создать новый дебетовый счёт,пока заглушка,
        // передавать для создания ничего не надо, будем обрабатывать по внутренней логике
    }

}
