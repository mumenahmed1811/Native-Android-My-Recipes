package com.example.myrecipes.pagination

import androidx.lifecycle.MutableLiveData
import com.example.myrecipes.data.MealX
import javax.sql.DataSource

class MealDataFactory(private val queryString : String) : androidx.paging.DataSource.Factory<Int, MealX>() {

    val mealLiveDataSource = MutableLiveData<MealDataSource>()

    override fun create(): androidx.paging.DataSource<Int, MealX> {
        val mealDataSource = MealDataSource(queryString)
        mealLiveDataSource.postValue(mealDataSource)
        return mealDataSource

    }
}