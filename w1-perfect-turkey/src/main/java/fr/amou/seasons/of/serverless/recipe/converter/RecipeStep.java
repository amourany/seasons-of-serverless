package fr.amou.seasons.of.serverless.recipe.converter;

import java.math.BigDecimal;
import java.util.Objects;

public class RecipeStep {
    private final String name;
    private final String unit;
    private final BigDecimal quantity;

    public RecipeStep(String name, String unit, BigDecimal quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "RecipeStep{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeStep that = (RecipeStep) o;
        return name.equals(that.name) &&
                unit.equals(that.unit) &&
                quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit, quantity);
    }
}
