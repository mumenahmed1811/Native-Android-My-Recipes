package com.example.myrecipes.fragments

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.bumptech.glide.Glide
import com.example.myrecipes.R
import com.example.myrecipes.ViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import kotlinx.android.synthetic.main.into_meal_fragment_layout.*
import kotlinx.android.synthetic.main.into_meal_fragment_layout.view.*
import com.bumptech.glide.Glide.with as with1

class IntoMealFragment: Fragment(R.layout.into_meal_fragment_layout){

    private val args by navArgs<IntoMealFragmentArgs>()

    // On view created because this fragment is created from time to time
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel : ViewModel by navGraphViewModels(R.id.nav_graph)

        getActivity()?.setTitle(args.mealData.strMeal);

        // Image
        Glide.with(view.image.context)
                .load(args.mealData.strMealThumb)
                .into(view.image)


        // Part 1
        view.meal_name.setText(args.mealData.strMeal)
        view.meal_area.setText(args.mealData.strArea)
        view.meal_category.setText(args.mealData.strCategory)

        // Part 2
        view.instructions.setText(args.mealData.strInstructions)
        view.youtube_link.setText(args.mealData.strYoutube)
        val uri = Uri.parse(args.mealData.strYoutube)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        view.youtube_link.apply {
            setOnClickListener{
                context.startActivity(intent)
            }
            paint.isUnderlineText= true
        }

        val ytp_link = args.mealData.strYoutube
        val video_id = ytp_link.substring(32, ytp_link.length)
        //Log.d(TAG, "Youtube ID: " + video_id)
        lifecycle.addObserver(video_player)

        video_player.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {

                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.cueVideo(video_id, 0F)

                    //youTubePlayer.pause()

                }

            })


        // Part 3
        if(args.mealData.strIngredient1 != null && args.mealData.strIngredient1 != ""){
            view.ingredient_1.isVisible=true
            view.ingredient_1.setText("Ingeriednt 1 : " + args.mealData.strIngredient1 + " Measures " + args.mealData.strMeasure1)
        }

        if(args.mealData.strIngredient2 != null && args.mealData.strIngredient2 != ""){
            view.ingredient_2.isVisible=true
            view.ingredient_2.setText("Ingeriednt 2 : " + args.mealData.strIngredient2 + " Measures " + args.mealData.strMeasure2)
        }

        if(args.mealData.strIngredient3 != null && args.mealData.strIngredient3 != ""){
            view.ingredient_3.isVisible=true
            view.ingredient_3.setText("Ingeriednt 3 : " + args.mealData.strIngredient3 + " Measures " + args.mealData.strMeasure3)
        }

        if(args.mealData.strIngredient4 != null && args.mealData.strIngredient4 != ""){
            view.ingredient_4.isVisible=true
            view.ingredient_4.setText("Ingeriednt 4 : " + args.mealData.strIngredient4 + " Measures " + args.mealData.strMeasure4)
        }

        if(args.mealData.strIngredient5 != null && args.mealData.strIngredient5 != ""){
            view.ingredient_5.isVisible=true
            view.ingredient_5.setText("Ingeriednt 5 : " + args.mealData.strIngredient5 + " Measures " + args.mealData.strMeasure5)
        }

        if(args.mealData.strIngredient6 != null && args.mealData.strIngredient6 != ""){
            view.ingredient_6.isVisible=true
            view.ingredient_6.setText("Ingeriednt 6 : " + args.mealData.strIngredient6 + " Measures " + args.mealData.strMeasure6)
        }

        if(args.mealData.strIngredient7 != null && args.mealData.strIngredient7 != ""){
            view.ingredient_7.isVisible=true
            view.ingredient_7.setText("Ingeriednt 7 : " + args.mealData.strIngredient7 + " Measures " + args.mealData.strMeasure7)
        }

        if(args.mealData.strIngredient8 != null && args.mealData.strIngredient8 != ""){
            view.ingredient_8.isVisible=true
            view.ingredient_8.setText("Ingeriednt 8 : " + args.mealData.strIngredient8 + " Measures " + args.mealData.strMeasure8)
        }

        if(args.mealData.strIngredient9 != null && args.mealData.strIngredient9 != ""){
            view.ingredient_9.isVisible=true
            view.ingredient_9.setText("Ingeriednt 9 : " + args.mealData.strIngredient9 + " Measures " + args.mealData.strMeasure9)
        }

        if(args.mealData.strIngredient10 != null && args.mealData.strIngredient10 != ""){
            view.ingredient_10.isVisible=true
            view.ingredient_10.setText("Ingeriednt 10 : " + args.mealData.strIngredient10 + " Measures " + args.mealData.strMeasure10)
        }


        if(args.mealData.strIngredient11 != null && args.mealData.strIngredient11 != ""){
            view.ingredient_11.isVisible=true
            view.ingredient_11.setText("Ingeriednt 11 : " + args.mealData.strIngredient11 + " Measures " + args.mealData.strMeasure11)
        }

        if(args.mealData.strIngredient12 != null && args.mealData.strIngredient12 != ""){
            view.ingredient_2.isVisible=true
            view.ingredient_12.setText("Ingeriednt 12 : " + args.mealData.strIngredient12 + " Measures " + args.mealData.strMeasure12)
        }

        if(args.mealData.strIngredient13 != null && args.mealData.strIngredient13 != ""){
            view.ingredient_13.isVisible=true
            view.ingredient_13.setText("Ingeriednt 13 : " + args.mealData.strIngredient13 + " Measures " + args.mealData.strMeasure13)
        }

        if(args.mealData.strIngredient14 != null && args.mealData.strIngredient14 != ""){
            view.ingredient_14.isVisible=true
            view.ingredient_14.setText("Ingeriednt 14 : " + args.mealData.strIngredient14 + " Measures " + args.mealData.strMeasure14)
        }

        if(args.mealData.strIngredient15 != null && args.mealData.strIngredient15 != ""){
            view.ingredient_15.isVisible=true
            view.ingredient_15.setText("Ingeriednt 15 : " + args.mealData.strIngredient15 + " Measures " + args.mealData.strMeasure15)
        }

        if(args.mealData.strIngredient16 != null && args.mealData.strIngredient16 != ""){
            view.ingredient_16.isVisible=true
            view.ingredient_16.setText("Ingeriednt 16 : " + args.mealData.strIngredient16 + " Measures " + args.mealData.strMeasure16)
        }

        if(args.mealData.strIngredient17 != null && args.mealData.strIngredient17 != ""){
            view.ingredient_17.isVisible=true
            view.ingredient_17.setText("Ingeriednt 17 : " + args.mealData.strIngredient17 + " Measures " + args.mealData.strMeasure17)
        }

        if(args.mealData.strIngredient18 != null && args.mealData.strIngredient18 != ""){
            view.ingredient_18.isVisible=true
            view.ingredient_18.setText("Ingeriednt 18 : " + args.mealData.strIngredient18 + " Measures " + args.mealData.strMeasure18)
        }

        if(args.mealData.strIngredient19 != null && args.mealData.strIngredient19 != ""){
            view.ingredient_19.isVisible=true
            view.ingredient_19.setText("Ingeriednt 19 : " + args.mealData.strIngredient19 + " Measures " + args.mealData.strMeasure19)
        }

        if(args.mealData.strIngredient20 != null && args.mealData.strIngredient20 != ""){
            view.ingredient_20.isVisible=true
            view.ingredient_20.setText("Ingeriednt 20 : " + args.mealData.strIngredient20 + " Measures " + args.mealData.strMeasure20)
        }


    }

    fun addFullScreen(){
        video_player.addFullScreenListener(object : YouTubePlayerFullScreenListener{
            override fun onYouTubePlayerEnterFullScreen() {
                activity?.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                video_player.enterFullScreen();
            }

            override fun onYouTubePlayerExitFullScreen() {
                activity?.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                video_player.exitFullScreen();
            }
        })
    }

}