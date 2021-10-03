package com.example.myrecipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrecipes.CocktailAdapter.Comparator
import com.example.myrecipes.data.Cocktail
import com.example.myrecipes.data.MealX
import kotlinx.android.synthetic.main.cocktail_item.view.*
import kotlinx.android.synthetic.main.meal_item.view.*
//val listener: CocktailAdapter.onItemClickListener
class CocktailAdapter(val listener: CocktailAdapter.onItemClickListener ): ListAdapter<Cocktail,CocktailAdapter.CocktaillViewHolder>(Comparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktaillViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.cocktail_item, parent, false)
        return CocktaillViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: CocktaillViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class CocktaillViewHolder(view : View): RecyclerView.ViewHolder(view){

        init {
            view.setOnClickListener{
                val position = adapterPosition
                val cocktail = getItem(position)
                if(position != RecyclerView.NO_POSITION){
                        listener.onItemClick(cocktail)
                    }
                }

        }

        private val imageView = view.cocktail_image
        private val cocktailName = view.cocktail_name
        private val cocktailCategory = view.cocktail_category

        fun bind(cocktail: Cocktail) {

            cocktailName.text = cocktail.strDrink
            cocktailCategory.text = cocktail.strCategory

            //Context of the view
            Glide.with(imageView.context) // Context
                    .load(cocktail.strDrinkThumb) // Data
                    .into(imageView) // View
        }
    }

    interface onItemClickListener{
        fun onItemClick(cocktail : Cocktail)
    }


    class Comparator : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail) =
                oldItem.idDrink == newItem.idDrink

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail) =
                oldItem == newItem
    }
}