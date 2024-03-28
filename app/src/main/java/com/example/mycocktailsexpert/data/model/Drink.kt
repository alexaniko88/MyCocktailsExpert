package com.example.mycocktailsexpert.data.model

import com.google.gson.annotations.SerializedName

data class Drink(
    val dateModified: String,
    val idDrink: String,
    @SerializedName("strAlcoholic")
    val alcoholic: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strCreativeCommonsConfirmed")
    val creativeCommonsConfirmed: String,
    @SerializedName("strDrink")
    val drink: String,
    @SerializedName("strDrinkAlternate")
    val drinkAlternate: Any,
    @SerializedName("strDrinkThumb")
    val drinkThumb: String,
    @SerializedName("strGlass")
    val glass: String,
    @SerializedName("strIBA")
    val iba: String,
    @SerializedName("strImageAttribution")
    val imageAttribution: String,
    @SerializedName("strImageSource")
    val imageSource: String,
    @SerializedName("strIngredient1")
    val ingredient1: String?,
    @SerializedName("strIngredient2")
    val ingredient2: String?,
    @SerializedName("strIngredient3")
    val ingredient3: String?,
    @SerializedName("strInstructions")
    val instructions: String?,
    @SerializedName("strInstructionsES")
    val instructionsES: String?,
    @SerializedName("strMeasure1")
    val measure1: String?,
    @SerializedName("strMeasure2")
    val measure2: String?,
    @SerializedName("strMeasure3")
    val measure3: String?,
    @SerializedName("strTags")
    val tags: String?,
    @SerializedName("strVideo")
    val video: String?
)