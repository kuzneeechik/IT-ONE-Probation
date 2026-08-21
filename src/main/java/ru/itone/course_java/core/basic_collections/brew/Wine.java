package ru.itone.course_java.core.basic_collections.brew;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Переопределите методы {@link Object#equals(Object)} и {@link Object#hashCode()} в этом классе и в {@link Grape} так,
 * чтобы два объекта класса {@link Wine} были одинаковыми при совпадении их:
 * - Наименования {@link Wine#getName()}
 * - Даты производства {@link Wine#getProduced()}
 * - Крепости {@link Wine#getAbv()}
 * - Объём не учитывается
 * - Источник сырья {@link Wine#getGrapeSource()} совпадает по нижеизложенным параметрам
 * <p>
 * Источник сырья считать одинаковым, если:
 * - Сорт {@link Grape#getSort()} совпадает
 * - Сахаристость {@link Grape#getBrix()} отличается не более чем на 0.2
 * - Кислотность {@link Grape#getAcidity()} отличается не более чем на 0.1
 * - Дата сбора {@link Grape#getCollected()} отличается не более чем на год
 */
public class Wine {

    private String name;
    private LocalDate produced;
    private int vol;
    private float abv;
    private Grape grapeSource;

    public Wine(String name, LocalDate produced, int vol, float abv, Grape grapeSource) {
        this.name = name;
        this.produced = produced;
        this.vol = vol;
        this.abv = abv;
        this.grapeSource = grapeSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Wine wine = (Wine) o;
        return name.equals(wine.getName()) &&
                produced == wine.getProduced() &&
                abv == wine.getAbv() &&
                grapeSource.equals(wine.getGrapeSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, produced, vol, abv, grapeSource);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getProduced() {
        return produced;
    }

    public void setProduced(LocalDate produced) {
        this.produced = produced;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public float getAbv() {
        return abv;
    }

    public void setAbv(float abv) {
        this.abv = abv;
    }

    public Grape getGrapeSource() {
        return grapeSource;
    }

    public void setGrapeSource(Grape grapeSource) {
        this.grapeSource = grapeSource;
    }
}
