package ru.itone.course_java.core.basic_collections.brew;

import java.time.LocalDate;
import java.util.Objects;

public class Grape {

    private String sort;
    private float brix;
    private float acidity;
    private LocalDate collected;

    public Grape(String sort, float brix, float acidity, LocalDate collected) {
        this.sort = sort;
        this.brix = brix;
        this.acidity = acidity;
        this.collected = collected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Grape grape = (Grape) o;
        return sort.equals(grape.sort) &&
                Math.abs(brix - grape.brix) <= 2 &&
                Math.abs(acidity - grape.acidity) <= 0.1f &&
                collected.isBefore(grape.collected.plusYears(1).plusDays(1)) &&
                collected.isAfter(grape.collected.minusYears(1).minusDays(1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(sort, brix, acidity, collected);
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public float getBrix() {
        return brix;
    }

    public void setBrix(float brix) {
        this.brix = brix;
    }

    public float getAcidity() {
        return acidity;
    }

    public void setAcidity(float acidity) {
        this.acidity = acidity;
    }

    public LocalDate getCollected() {
        return collected;
    }

    public void setCollected(LocalDate collected) {
        this.collected = collected;
    }
}
