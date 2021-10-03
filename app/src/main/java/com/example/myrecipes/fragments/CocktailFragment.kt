package com.example.myrecipes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecipes.CocktailAdapter
import com.example.myrecipes.MealAdapter
import com.example.myrecipes.R
import com.example.myrecipes.ViewModel
import com.example.myrecipes.data.Cocktail
import com.example.myrecipes.data.MealX
import kotlinx.android.synthetic.main.cocktail_fragment_layout.*
import kotlinx.android.synthetic.main.cocktail_item.*
import kotlinx.android.synthetic.main.cocktail_fragment_layout.cocktail_search_view as search_view

//, CocktailAdapter.onItemClickListener
class CocktailFragment:Fragment(R.layout.cocktail_fragment_layout), CocktailAdapter.onItemClickListener {

     //val cocktailList : LiveData<List<Cocktail>>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val viewModel : ViewModel by navGraphViewModels(R.id.nav_graph)
        search_view.queryHint = "Search For Something To Drink.."

        getActivity()?.setTitle("Cocktails");

        val adapter = CocktailAdapter(this)
        recycler_view_id.adapter = adapter
        recycler_view_id.layoutManager = LinearLayoutManager(this.context)
        recycler_view_id.setHasFixedSize(true)


        val viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        //getCocktail("Margarita")
        val data = viewModel.getCocktails("Margarita")
        data.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query != null){
                    recycler_view_id.scrollToPosition(0)
                    viewModel.getCocktails(query).observe(viewLifecycleOwner, Observer<List<Cocktail>> {
                        adapter.submitList(it)
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

    override fun onItemClick(cocktail: Cocktail) {
        val action = CocktailFragmentDirections.actionCocktailFragmentToIntoCocktailFragment(cocktail,cocktail.strDrink)
        findNavController().navigate(action)
    }
}


