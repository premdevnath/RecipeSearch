package com.example.aiapi

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aiapi.databinding.ItemaddfavBinding

class newadapter (var context: Context/*, var foodName:ArrayList<String>, var foodImage:ArrayList<String>*/
):RecyclerView.Adapter<newadapter.ViewHolder>() {

    private var foodImages: String = ""
    private var foodNames: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newadapter.ViewHolder {
           var layoutInflater=LayoutInflater.from(parent.context)
        var binding=ItemaddfavBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: newadapter.ViewHolder, position: Int) {
      //  holder.bind(position)
        holder.bind(foodImages, foodNames)
    }

    override fun getItemCount(): Int {
       //return foodName.size
       return 1

    }
    fun setMeals(image: String, name: String)
    {
        this.foodImages = image
        this.foodNames = name
        notifyDataSetChanged()
    }

   inner class ViewHolder (var binding: ItemaddfavBinding):RecyclerView.ViewHolder(binding.root){
       fun bind(foodImage: String, foodName: String) {

           var uri=foodImage
           Log.d("datalast", "bind: ${uri}")
           var image=Uri.parse(uri)
           Glide.with(context).load(image).into(binding.recipeimage1)
           binding.recipetitle1.text=foodName
       }
       /*  fun bind(position: Int) {
             var uri=foodImage[position]
             Log.d("datalast", "bind: ${uri}")
             var image=Uri.parse(uri)
             Glide.with(context).load(image).into(binding.recipeimage1)
             binding.recipetitle1.text=foodName[position]

         }

        */

   }
}