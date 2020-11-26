package fr.amou.seasons.of.serverless.recipe.converter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IngredientQuantityConverterTest {

    @Test
    void it_should_convert_a_list_of_ingredients() {
        // Given
        double weight = 5;
        RecipeConverter converter = new IngredientQuantityConverter(List.of(Ingredient.SALT, Ingredient.SHALLOTS));

        // When
        List<RecipeStep> steps = converter.convert(weight);

        // Then
        RecipeStep expectedSaltStep = new RecipeStep(Ingredient.SALT.getName(), Ingredient.SALT.getUnit(), new BigDecimal("0.25"));
        RecipeStep expectedShallotsStep = new RecipeStep(Ingredient.SHALLOTS.getName(), Ingredient.SHALLOTS.getUnit(), BigDecimal.ONE);
        assertThat(steps).isEqualTo(List.of(expectedSaltStep, expectedShallotsStep));
    }

}