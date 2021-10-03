package com.example.myrecipes.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.bumptech.glide.Glide
import com.example.myrecipes.R
import com.example.myrecipes.ViewModel
import kotlinx.android.synthetic.main.into_cocktail_fragment_layout.view.*
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.*
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.image
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_1
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_10
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_11
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_12
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_13
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_14
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_15
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_2
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_3
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_4
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_5
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_6
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_7
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_8
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.ingredient_9
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.meal_name

class IntoCocktailFragment: Fragment(R.layout.into_cocktail_fragment_layout) {
    private val args by navArgs<IntoCocktailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel : ViewModel by navGraphViewModels(R.id.nav_graph)
        getActivity()?.setTitle(args.cocktailData.strDrink);

        // Image
        Glide.with(view.image.context)
                .load(args.cocktailData.strDrinkThumb)
                .into(view.image)


        // Part 1
        view.cocktail_name.setText(args.cocktailData.strDrink)
        view.cocktail_category.setText(args.cocktailData.strCategory)



        // Part 3
        if(args.cocktailData.strIngredient1 != null && args.cocktailData.strIngredient1 != ""){
            view.ingredient_1.isVisible=true
            view.ingredient_1.setText("Ingeriednt 1 : " + args.cocktailData.strIngredient1 + " Measures " + args.cocktailData.strMeasure1)
        }

        if(args.cocktailData.strIngredient2 != null && args.cocktailData.strIngredient2 != ""){
            view.ingredient_2.isVisible=true
            view.ingredient_2.setText("Ingeriednt 2 : " + args.cocktailData.strIngredient2 + " Measures " + args.cocktailData.strMeasure2)
        }

        if(args.cocktailData.strIngredient3 != null && args.cocktailData.strIngredient3 != ""){
            view.ingredient_3.isVisible=true
            view.ingredient_3.setText("Ingeriednt 3 : " + args.cocktailData.strIngredient3 + " Measures " + args.cocktailData.strMeasure3)
        }

        if(args.cocktailData.strIngredient4 != null && args.cocktailData.strIngredient4 != ""){
            view.ingredient_4.isVisible=true
            view.ingredient_4.setText("Ingeriednt 4 : " + args.cocktailData.strIngredient4 + " Measures " + args.cocktailData.strMeasure4)
        }

        if(args.cocktailData.strIngredient5 != null && args.cocktailData.strIngredient5 != ""){
            view.ingredient_5.isVisible=true
            view.ingredient_5.setText("Ingeriednt 5 : " + args.cocktailData.strIngredient5 + " Measures " + args.cocktailData.strMeasure5)
        }

        if(args.cocktailData.strIngredient6 != null && args.cocktailData.strIngredient6 != ""){
            view.ingredient_6.isVisible=true
            view.ingredient_6.setText("Ingeriednt 6 : " + args.cocktailData.strIngredient6 + " Measures " + args.cocktailData.strMeasure6)
        }

        if(args.cocktailData.strIngredient7 != null && args.cocktailData.strIngredient7 != ""){
            view.ingredient_7.isVisible=true
            view.ingredient_7.setText("Ingeriednt 7 : " + args.cocktailData.strIngredient7 + " Measures " + args.cocktailData.strMeasure7)
        }

        if(args.cocktailData.strIngredient8 != null && args.cocktailData.strIngredient8 != ""){
            view.ingredient_8.isVisible=true
            view.ingredient_8.setText("Ingeriednt 8 : " + args.cocktailData.strIngredient8 + " Measures " + args.cocktailData.strMeasure8)
        }

        if(args.cocktailData.strIngredient9 != null && args.cocktailData.strIngredient9 != ""){
            view.ingredient_9.isVisible=true
            view.ingredient_9.setText("Ingeriednt 9 : " + args.cocktailData.strIngredient9 + " Measures " + args.cocktailData.strMeasure9)
        }

        if(args.cocktailData.strIngredient10 != null && args.cocktailData.strIngredient10 != ""){
            view.ingredient_10.isVisible=true
            view.ingredient_10.setText("Ingeriednt 10 : " + args.cocktailData.strIngredient10 + " Measures " + args.cocktailData.strMeasure10)
        }


        if(args.cocktailData.strIngredient11 != null && args.cocktailData.strIngredient11 != ""){
            view.ingredient_11.isVisible=true
            view.ingredient_11.setText("Ingeriednt 11 : " + args.cocktailData.strIngredient11 + " Measures " + args.cocktailData.strMeasure11)
        }

        if(args.cocktailData.strIngredient12 != null && args.cocktailData.strIngredient12 != ""){
            view.ingredient_2.isVisible=true
            view.ingredient_12.setText("Ingeriednt 12 : " + args.cocktailData.strIngredient12 + " Measures " + args.cocktailData.strMeasure12)
        }

        if(args.cocktailData.strIngredient13 != null && args.cocktailData.strIngredient13 != ""){
            view.ingredient_13.isVisible=true
            view.ingredient_13.setText("Ingeriednt 13 : " + args.cocktailData.strIngredient13 + " Measures " + args.cocktailData.strMeasure13)
        }

        if(args.cocktailData.strIngredient14 != null && args.cocktailData.strIngredient14 != ""){
            view.ingredient_14.isVisible=true
            view.ingredient_14.setText("Ingeriednt 14 : " + args.cocktailData.strIngredient14 + " Measures " + args.cocktailData.strMeasure14)
        }

        if(args.cocktailData.strIngredient15 != null && args.cocktailData.strIngredient15 != ""){
            view.ingredient_15.isVisible=true
            view.ingredient_15.setText("Ingeriednt 15 : " + args.cocktailData.strIngredient15 + " Measures " + args.cocktailData.strMeasure15)
        }




    }
}