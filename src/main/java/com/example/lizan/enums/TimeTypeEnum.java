package com.example.lizan.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lizan
 * @version $Id: ChargeUnitEnum.java, v 0.1 2023年01月12日 14:21 lizan Exp $$
 */
@Getter
@AllArgsConstructor
public enum TimeTypeEnum {
    YEAR(1, "年", BigDecimal.valueOf(24 * 60 * 60 * 365)),
    MOUTH(2, "月", BigDecimal.valueOf(24 * 60 * 60 * 30)),
    DAY(3, "日", BigDecimal.valueOf(24 * 60 * 60)),
    ;

    private final int code;

    private final String desc;

    private final BigDecimal second;

    @JsonValue
    public int getCode() {
        return code;
    }

    public static TimeTypeEnum getByCode(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }
        for (TimeTypeEnum value : TimeTypeEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    static final Map<Integer, TimeTypeEnum> timeTypeEnumHashMap = new HashMap<>(TimeTypeEnum.values().length);

    static {
        for (TimeTypeEnum item : TimeTypeEnum.values()) {
            timeTypeEnumHashMap.put(item.code, item);
        }
    }

    @JsonCreator
    public static TimeTypeEnum parseType(Integer source) {
        return timeTypeEnumHashMap.get(source);
    }
}
