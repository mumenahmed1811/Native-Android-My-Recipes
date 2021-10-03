package com.example.myrecipes.pagination

import androidx.paging.PageKeyedDataSource
import com.example.myrecipes.data.MealResponse
import com.example.myrecipes.data.MealX
import com.example.myrecipes.retrofit.MealService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val FIRST_PAGE = 1

class MealDataSource(
        private val queryString: String
): PageKeyedDataSource<Int, MealX>() {

    override fun loadInitial(
            params: LoadInitialParams<Int>,
            callback: LoadInitialCallback<Int, MealX>
    ) {
        val service = MealService.getMealService()
        val call = service.getMeal(queryString)

        call.enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                if(response.isSuccessful){
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.meals

                    responseItems?.let {
                        callback.onResult(responseItems,null, null)
                    }
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
            }
        })


    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MealX>) {

        val service = MealService.getMealService()
        val call = service.getMeal(queryString)

        call.enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                if(response.isSuccessful){
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.meals

                    //val key = if ( params.key > 1 ) (params.key-1) else null

                    responseItems?.let {
                        callback.onResult(responseItems,null)
                    }
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
            }
        })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MealX>) {
        val service = MealService.getMealService()
        val call = service.getMeal(queryString)

        call.enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                if(response.isSuccessful){

                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.meals

                    //val key = params.key + 1

                    responseItems?.let {
                        callback.onResult(responseItems,null)
                    }
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
            }
        })
    }

}