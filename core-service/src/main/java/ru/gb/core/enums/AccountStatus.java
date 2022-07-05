package ru.gb.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Типы статусов
 */
@Getter
@AllArgsConstructor
public enum AccountStatus {

    ACTIVE(1, "Активен"),
    BLOCKED(2, "Заблокирован"),
    CLOSED(3, "Закрыт");

    private final static Map<Integer, AccountStatus> LOOKUP_BY_ID = Stream
            .of(AccountStatus.values())
            .collect(Collectors.toMap(AccountStatus::getId, Function.identity()));

    private final int id;

    private final String description;

    @NonNull
    public static AccountStatus getById(final int statusId) {
        return LOOKUP_BY_ID.get(statusId);
    }

    @Converter(autoApply = true)
    public static class AccountStatusConverter implements AttributeConverter<AccountStatus, Integer> {
        @Override
        @NonNull
        public Integer convertToDatabaseColumn(@NonNull final AccountStatus accountStatus) {
            return accountStatus.id;
        }

        @Override
        @NonNull
        public AccountStatus convertToEntityAttribute(@NonNull final Integer accountStatusId) {
            return LOOKUP_BY_ID.get(accountStatusId);
        }
    }
}
