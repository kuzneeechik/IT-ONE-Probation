package ru.itone.course_java.core.base_structures.precise;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record PreciseFloatClass(int whole, int fractional) implements PreciseFloat {

    private static final int PRECISION = 1000000;

    public int getWhole() {
        return whole;
    }

    public int getFractional() {
        return fractional;
    }

    public PreciseFloat add(PreciseFloat a) {
        int newWhole = whole + a.getWhole();
        int newFractional = fractional + a.getFractional();

        if (newFractional >= PRECISION) {
            newWhole += newFractional / PRECISION;
            newFractional %= PRECISION;
        }

        return new PreciseFloatClass(newWhole, newFractional);
    }

    public PreciseFloat subtract(PreciseFloat a) {
        int newWhole = whole - a.getWhole();
        int newFractional = fractional - a.getFractional();

        if (newFractional < 0) {
            newWhole--;
            newFractional += 1000000;
        }

        return new PreciseFloatClass(newWhole, newFractional);
    }

    public PreciseFloat multiply(PreciseFloat a) {
        BigDecimal first = BigDecimal.valueOf((long) whole * PRECISION + fractional);
        BigDecimal second = BigDecimal.valueOf((long) a.getWhole() * PRECISION + a.getFractional());

        BigDecimal result = first
                .multiply(second)
                .divide(
                        BigDecimal.valueOf(PRECISION),
                        0,
                        RoundingMode.HALF_UP
                );

        int newWhole = result
                .divide(BigDecimal.valueOf(PRECISION), 0, RoundingMode.FLOOR)
                .intValue();

        int newFractional = result
                .remainder(BigDecimal.valueOf(PRECISION))
                .intValue();

        return new PreciseFloatClass(newWhole, newFractional);
    }

    public PreciseFloat divide(PreciseFloat a) {
        BigDecimal first = BigDecimal.valueOf((long) whole * PRECISION + fractional);
        BigDecimal second = BigDecimal.valueOf((long) a.getWhole() * PRECISION + a.getFractional());

        BigDecimal result = first
                .multiply(BigDecimal.valueOf(PRECISION))
                .divide(
                        second,
                        0,
                        RoundingMode.HALF_UP
                );

        int newWhole = result
                .divide(BigDecimal.valueOf(PRECISION), 0, RoundingMode.FLOOR)
                .intValue();

        int newFractional = result
                .remainder(BigDecimal.valueOf(PRECISION))
                .intValue();


        return new PreciseFloatClass(newWhole, newFractional);
    }

    public String asString() {
        StringBuilder newFractional = new StringBuilder(fractional + "");

        while (newFractional.length() < 6) {
            newFractional.insert(0, "0");
        }

        return whole + "." + newFractional;
    }
}
