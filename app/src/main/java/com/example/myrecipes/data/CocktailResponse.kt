package com.example.myrecipes.data

import com.google.gson.annotations.SerializedName

data class CocktailResponse(
        @SerializedName("drinks")
        val cocktails: List<Cocktail>
)
