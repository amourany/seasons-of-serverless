package fr.amou.seasons.of.serverless.recipe.converter;

import java.util.List;

import static fr.amou.seasons.of.serverless.recipe.converter.Ingredient.INGREDIENTS;

public class IngredientQuantityConverter extends AbstractRecipeConverter {

    public IngredientQuantityConverter(List<Ingredient> ingredients) {
        super(ingredients);
    }

    public IngredientQuantityConverter() {
        super(INGREDIENTS);
    }
}
