package fr.amou.seasons.of.serverless;

import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import fr.amou.seasons.of.serverless.recipe.converter.CookingInstructionQuantityConverter;
import fr.amou.seasons.of.serverless.recipe.converter.IngredientQuantityConverter;
import fr.amou.seasons.of.serverless.recipe.converter.RecipeConverter;
import fr.amou.seasons.of.serverless.recipe.converter.RecipeStep;

import java.util.List;
import java.util.Optional;

public class TurkeyRecipeFunction {

    @FunctionName("turkey-recipe")
    public HttpResponseMessage run(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage<Optional<String>> request) {

        final String turkeyWeight = request.getQueryParameters().get("weight");

        try {
            double weight = Double.parseDouble(turkeyWeight);

            RecipeConverter ingredientConverter = new IngredientQuantityConverter();
            List<RecipeStep> ingredients = ingredientConverter.convert(weight);

            RecipeConverter instructionConverter = new CookingInstructionQuantityConverter();
            List<RecipeStep> cookingTimes = instructionConverter.convert(weight);

            String recipe = buildResponseMessage(ingredients, cookingTimes);

            return request.createResponseBuilder(HttpStatus.OK).body(recipe).build();
        } catch (RuntimeException e) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Invalid weight").build();
        }

    }

    private String buildResponseMessage(List<RecipeStep> ingredients, List<RecipeStep> cookingTimes) {
        StringBuilder sb = new StringBuilder();
        sb.append("For cooking the perfect turkey, you will need :\n");

        ingredients.forEach(ingredient -> sb.append(String.format(" - %s %s of %s%n", ingredient.getQuantity().toPlainString(), ingredient.getUnit(), ingredient.getName())));

        sb.append("Mix all these ingredients in a large cooler with your turkey, then : \n");

        cookingTimes.forEach(recipeStep ->
                sb.append(String.format(" - %s it for %s %s.%n",
                        recipeStep.getName(),
                        recipeStep.getQuantity().toPlainString(),
                        recipeStep.getUnit())));
        sb.append("Happy Thanksgiving!");
        return sb.toString();
    }
}
