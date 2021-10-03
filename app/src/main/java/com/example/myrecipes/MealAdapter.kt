package com.example.myrecipes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrecipes.data.MealX
import kotlinx.android.synthetic.main.meal_item.view.*

class MealAdapter(val listener: onItemClickListener)
    : PagedListAdapter<MealX, MealAdapter.MealViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context).
            inflate(R.layout.meal_item,parent,false)

        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = getItem(position)
        meal?.let { holder. bind(meal)}
    }


    // Lazm yb2a inner 34an yst3ml l variables bta3t l class l outer
    inner class MealViewHolder(view: View): RecyclerView.ViewHolder(view){

        init {
            view.setOnClickListener{
                val position = adapterPosition
                if(position != -1){
                    val item = getItem(position)
                    if(item != null){
                        listener.onItemClick(item)
                    }
                }
            }
        }

        private val imageView = view.meal_image
        private val mealName = view.meal_name
        private val mealCategory = view.meal_category
        private val mealArea = view.meal_area

        fun bind(meal: MealX) {

            mealName.text = meal.strMeal
            mealCategory.text = meal.strCategory
            mealArea.text = meal.strArea

            //Context of the view
            Glide.with(imageView.context) // Context
                .load(meal.strMealThumb) // Data
                .into(imageView) // View
        }

    }

    interface onItemClickListener{
        fun onItemClick(meal : MealX)
    }

    companion object{
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<MealX>() {
            override fun areItemsTheSame(oldItem: MealX, newItem: MealX): Boolean =
                    oldItem.idMeal == newItem.idMeal

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: MealX, newItem: MealX): Boolean =
                    newItem == oldItem

        }
    }
}