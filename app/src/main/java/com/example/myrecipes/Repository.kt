package com.example.myrecipes

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myrecipes.data.Cocktail
import com.example.myrecipes.data.CocktailResponse
import com.example.myrecipes.data.MealX
import com.example.myrecipes.pagination.MealDataFactory
import com.example.myrecipes.pagination.MealDataSource
import com.example.myrecipes.retrofit.CocktailService
import retrofit2.Call
import retrofit2.Response
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.room.Transaction
import androidx.room.RoomDatabase
import com.example.myrecipes.database.DaoClass
import com.example.myrecipes.database.MyDatabase
import com.example.myrecipes.utils.networkBoundResource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import retrofit2.Callback

class Repository {
    //***************************************
    //Only API PART
    //***************************************

    lateinit var mealPagedList : LiveData<PagedList<MealX>>
    lateinit var liveDataSource : LiveData<MealDataSource>
    lateinit var repository_cocktailList : MutableLiveData<List<Cocktail>>

    init {
        repository_cocktailList = MutableLiveData()
    }

    public fun initData(query:String):LiveData<PagedList<MealX>>{

        val itemDataSourceFactory = MealDataFactory(query)
        liveDataSource = itemDataSourceFactory.mealLiveDataSource

        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .setMaxSize(30)
                .setPrefetchDistance(5)
                .setInitialLoadSizeHint(10)
                .build()

        mealPagedList =  LivePagedListBuilder(itemDataSourceFactory,config)
                .build()
        return mealPagedList
    }

    init {

    }

    public fun getCocktailData(query: String): MutableLiveData<List<Cocktail>> {
        val retrofit = CocktailService.getCocktailService()
        val call = retrofit.getCocktail(query)

        call.enqueue(object :Callback<CocktailResponse>{
            override fun onResponse(call: Call<CocktailResponse>, response: Response<CocktailResponse>) {
                if(response.isSuccessful){
                    repository_cocktailList.postValue(response.body()?.cocktails)
                }
            }

            override fun onFailure(call: Call<CocktailResponse>, t: Throwable) {
                repository_cocktailList.postValue(null)
            }
        })

        return repository_cocktailList

    }


//**************************************
//API CAHSING API PART
//**************************************
    /*
    lateinit var cocktail_list : List<Cocktail>

    inner class getCocktails(app: Application, val query: String) {

        //Database Instance
        // A7a nset . build
        val db = Room.databaseBuilder(
                app,
                MyDatabase::class.java,
                "cocktail_database"
        ).build()

        val dao_intance = db.roomDao()


        fun getCocktails() = networkBoundResource(
                query = {
                        dao_intance.getAllCocktails()
                },
                fetch = {
                    delay(2000)
                    setCocktailData(query)
                },
                saveFetchResult = { restaurants ->
                        dao_intance.deleteAllCocktails()
                        dao_intance.insertCocktail(cocktail_list)
                }
        )
    }

    fun setCocktailData(query: String) {
        val retrofit = CocktailService.getCocktailService()
        val call = retrofit.getCocktail(query)

        call.enqueue(object :Callback<CocktailResponse>{
            override fun onResponse(call: Call<CocktailResponse>, response: Response<CocktailResponse>) {
                if(response.isSuccessful)
                    cocktail_list = response.body()?.cocktails!!
                else
                    cocktail_list = emptyList()
            }
            override fun onFailure(call: Call<CocktailResponse>, t: Throwable) {
                cocktail_list = emptyList()
            }
        })
    }*/
}




