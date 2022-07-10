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
 * Типы переводов
 */
@Getter
@AllArgsConstructor
public enum TransferDirection {

    C_TO_C(1, "Кредитный - Кредитный"),
    C_TO_D(2, "Кредитный - Дебетовый"),
    D_TO_C(3, "Дебетовый - Кредитный"),
    D_TO_D(4, "Дебетовый - Дебетовый");

    private final static Map<Integer, TransferDirection> LOOKUP_BY_ID = Stream
            .of(TransferDirection.values())
            .collect(Collectors.toMap(TransferDirection::getId, Function.identity()));

    private final int id;

    private final String description;

    @NonNull
    public static TransferDirection getById(final int transferDirectionId) {
        return LOOKUP_BY_ID.get(transferDirectionId);
    }

    @Converter(autoApply = true)
    public static class TransferDirectionConverter implements AttributeConverter<TransferDirection, Integer> {
        @Override
        @NonNull
        public Integer convertToDatabaseColumn(@NonNull final TransferDirection transferDirection) {
            return transferDirection.id;
        }

        @Override
        @NonNull
        public TransferDirection convertToEntityAttribute(@NonNull final Integer transferDirectionId) {
            return LOOKUP_BY_ID.get(transferDirectionId);
        }
    }
}
