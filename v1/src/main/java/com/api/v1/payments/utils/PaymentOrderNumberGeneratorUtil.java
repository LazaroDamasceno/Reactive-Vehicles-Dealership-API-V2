package com.api.v1.payments.utils;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.time.LocalDateTime;

@UtilityClass
public class PaymentOrderNumberGeneratorUtil {

    private final int year = LocalDateTime.now().getYear();
    private final int month = LocalDateTime.now().getYear();
    private final int day = LocalDateTime.now().getYear();
    private final int hour = LocalDateTime.now().getHour();
    private final int minute = LocalDateTime.now().getMinute();
    private final int second = LocalDateTime.now().getSecond();
    private final String strFormat = "%s%s%s0%s%s%s0000".formatted(year, month, day, hour, minute, second);
    private BigInteger biFormat = new BigInteger(strFormat);

    public BigInteger generate() {
        biFormat = biFormat.add(BigInteger.ONE);
        return biFormat;
    }

}
