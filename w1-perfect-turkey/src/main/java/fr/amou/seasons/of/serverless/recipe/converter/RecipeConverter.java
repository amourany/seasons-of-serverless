package fr.amou.seasons.of.serverless.recipe.converter;

import java.util.List;

public interface RecipeConverter {

    List<RecipeStep> convert(double weight);

}
