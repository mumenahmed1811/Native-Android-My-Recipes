package com.example.myrecipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myrecipes.data.Cocktail
import com.example.myrecipes.data.MealX
import com.example.myrecipes.pagination.MealDataFactory
import com.example.myrecipes.pagination.MealDataSource
import com.example.myrecipes.retrofit.CocktailService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel(): ViewModel() {

    val repository : Repository
    init {
        repository = Repository()
    }

    fun getCocktails(query: String) : MutableLiveData<List<Cocktail>>{
        return repository.getCocktailData(query)
    }

    fun getMeals(query: String):  LiveData<PagedList<MealX>>{
        return repository.initData(query)
    }


}