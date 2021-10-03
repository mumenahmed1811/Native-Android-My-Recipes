package com.example.myrecipes.retrofit

import android.telecom.Call
import androidx.lifecycle.LiveData
import com.example.myrecipes.data.Cocktail
import com.example.myrecipes.data.CocktailResponse
import com.example.myrecipes.data.MealResponse
import com.example.myrecipes.data.MealX
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    //@GET("/everything?q=sports&apiKey=aa67d8d98c8e4ad1b4f16dbd5f3be348")
    //fun getNews(@Query("page") page: Int, @Query("pageSize") pageSize: Int): Single<Response>


    @GET("search.php")
    fun getMeal(@Query("s") search: String ): retrofit2.Call<MealResponse>


    @GET("random.php")
    fun getRandomMeals(): retrofit2.Call<MealResponse>

    @GET("search.php")
    fun getCocktail(@Query("s") search: String ): retrofit2.Call<CocktailResponse>

    @GET("random.php")
    fun getRandomCocktails(): List<CocktailResponse>

}