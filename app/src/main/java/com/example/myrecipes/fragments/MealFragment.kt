package com.example.myrecipes.fragments

import android.icu.number.IntegerWidth
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.paging.PagedList
import com.example.myrecipes.MealAdapter
import com.example.myrecipes.R
import com.example.myrecipes.ViewModel
import com.example.myrecipes.data.MealX
import kotlinx.android.synthetic.main.meals_fragment_layout.*

class MealFragment: Fragment(R.layout.meals_fragment_layout), MealAdapter.onItemClickListener {

    lateinit var mealPagedList : LiveData<PagedList<MealX>>

    // On view created because this fragment is created from time to time
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val viewModel : ViewModel by navGraphViewModels(R.id.nav_graph)
        //this.state

        getActivity()?.setTitle("Meals");
        search_view.queryHint = "Search For Something To Eat.."


        val adapter = MealAdapter(this)

        recycler_view.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        mealPagedList = viewModel.getMeals("egg")
        mealPagedList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query != null){
                    recycler_view.scrollToPosition(0)
                    mealPagedList = viewModel.getMeals(query)
                    mealPagedList.observe(viewLifecycleOwner, Observer<PagedList<MealX>> {
                        adapter.submitList(it)
                        adapter.notifyDataSetChanged()
                    })
                    search_view.clearFocus()
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

    }

    override fun onItemClick(meal: MealX) {
        val action = MealFragmentDirections.actionMealFragmentToIntoMealFragment(meal, meal.strMeal)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}