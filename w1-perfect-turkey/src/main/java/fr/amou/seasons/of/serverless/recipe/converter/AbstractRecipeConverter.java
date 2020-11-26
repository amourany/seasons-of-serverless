package fr.amou.seasons.of.serverless.recipe.converter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.RoundingMode.HALF_UP;

public class AbstractRecipeConverter implements RecipeConverter {

    public static final MathContext MATH_CONTEXT = new MathContext(2, HALF_UP);

    private final List<Ingredient> ingredients;

    protected AbstractRecipeConverter(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<RecipeStep> convert(double weight) {
        return ingredients.stream()
                .map(ingredient -> convertAnIngredient(ingredient, weight))
                .collect(Collectors.toList());
    }

    private RecipeStep convertAnIngredient(Ingredient ingredient, double weight) {
        BigDecimal quantity = ingredient.getRatio()
                .multiply(BigDecimal.valueOf(weight), MATH_CONTEXT)
                .stripTrailingZeros();
        return new RecipeStep(ingredient.getName(), ingredient.getUnit(), quantity);
    }
}
