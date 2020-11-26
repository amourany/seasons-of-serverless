package fr.amou.seasons.of.serverless.recipe.converter;

import java.math.BigDecimal;
import java.util.List;

public enum Ingredient {
    SALT("salt", "cups", 0.05),
    WATER("water", "gallons", 0.66),
    SUGAR("brown sugar", "cups", 0.13),
    SHALLOTS("shallots", "", 0.2),
    GARLIC("garlic", "cloves", 0.4),
    PEPPERCORNS("whole peppercorns", "tablespoons", 0.13),
    BERRIES("dried juniper berries", "tablespoons", 0.13),
    ROSEMARY("fresh rosemary", "tablespoons", 0.13),
    THYME("thyme", "tablespoons", 0.06),
    BRINE("brine", "hours", 2.4),
    ROAST("roast", "minutes", 15);

    public static final List<Ingredient> INGREDIENTS = List.of(SALT, WATER, SUGAR, SHALLOTS, GARLIC, PEPPERCORNS, BERRIES, ROSEMARY, THYME);
    public static final List<Ingredient> COOKING_INSTRUCTIONS = List.of(BRINE, ROAST);
    private final String name;
    private final String unit;
    private final double ratio;

    Ingredient(String name, String unit, double ratio) {
        this.name = name;
        this.unit = unit;
        this.ratio = ratio;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public BigDecimal getRatio() {
        return BigDecimal.valueOf(ratio);
    }

}
