package com.example.myrecipes.database

import androidx.room.*
import com.example.myrecipes.data.MealX
import com.example.myrecipes.data.Cocktail as Cocktail

@Dao
interface DaoClass{
    @Query("SELECT * FROM Cocktail")
    fun getAllCocktails(): kotlinx.coroutines.flow.Flow<List<Cocktail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktail(cocktails: List<Cocktail>)

    @Query("DELETE FROM Cocktail")
    suspend fun deleteAllCocktails()

    @Delete
    fun deleteCocktail(cocktail: Cocktail)

    @Query("SELECT * FROM Meal")
    fun getAllMeals(): kotlinx.coroutines.flow.Flow<List<MealX>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meals: List<MealX>)

    @Query("DELETE FROM Meal")
    suspend fun deleteAllMeals()

    @Delete
    fun deleteMeal(meal: MealX)
}