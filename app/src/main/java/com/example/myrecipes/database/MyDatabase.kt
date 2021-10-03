package com.example.myrecipes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myrecipes.data.Cocktail
import com.example.myrecipes.data.MealX

@Database(entities = [Cocktail::class, MealX::class], version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun roomDao() : DaoClass
}

