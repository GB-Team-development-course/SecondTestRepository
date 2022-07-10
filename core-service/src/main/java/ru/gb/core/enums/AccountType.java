package ru.gb.core.enums;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Тип счета
 */
@AllArgsConstructor
public enum AccountType {
    C(1, "Кредитный счет"),
    D(2, "Депозитный счет");

    private final int id;

    private final String description;
    private final static Map<Integer, AccountType> LOOKUP_BY_ID = Stream
            .of(AccountType.values())
            .collect(Collectors.toMap(accountType -> accountType.id, Function.identity()));


    @Converter(autoApply = true)
    public static class AccountTypeConverter implements AttributeConverter<AccountType, Integer> {
        @Override
        @NonNull
        public Integer convertToDatabaseColumn(@NonNull final AccountType accountType) {
            return accountType.id;
        }

        @Override
        @NonNull
        public AccountType convertToEntityAttribute(@NonNull final Integer accountTypeId) {
            return LOOKUP_BY_ID.get(accountTypeId);
        }
    }
}
