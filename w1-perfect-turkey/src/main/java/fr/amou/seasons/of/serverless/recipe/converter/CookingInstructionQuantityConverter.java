package fr.amou.seasons.of.serverless.recipe.converter;

import java.util.List;

import static fr.amou.seasons.of.serverless.recipe.converter.Ingredient.COOKING_INSTRUCTIONS;

public class CookingInstructionQuantityConverter extends AbstractRecipeConverter {
    public CookingInstructionQuantityConverter(List<Ingredient> cookingInstructions) {
        super(cookingInstructions);
    }

    public CookingInstructionQuantityConverter() {
        super(COOKING_INSTRUCTIONS);
    }
}
