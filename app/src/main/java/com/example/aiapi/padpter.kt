package com.example.aiapi

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aiapi.databinding.ItemRecipeBinding
import com.example.aiapi.databinding.ItemRecipePopularBinding

class padpter(var requireContext: Context,var meals:ArrayList<ResultX>):RecyclerView.Adapter<padpter.ViewHolder>() {

 //   private var meals = emptyList<ResultX>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): padpter.ViewHolder {
        var layoutInflater= LayoutInflater.from(parent.context)
        var binding= ItemRecipePopularBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: padpter.ViewHolder, position: Int) {
        val currentItem = meals[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
       return meals.size
    }
    fun setMeals() {

      //  this.meals = meals
        notifyDataSetChanged()
    }


    inner class ViewHolder (var binding:ItemRecipePopularBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(currentItem: ResultX) {
          binding.recipeTitle.text=currentItem.title
            val image=currentItem.image
            val uri=Uri.parse(image)
            Glide.with(requireContext).load(uri).into(binding.recipeImage)
        }



    }

}