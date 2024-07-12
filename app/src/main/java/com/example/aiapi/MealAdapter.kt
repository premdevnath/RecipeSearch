package com.example.aiapi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aiapi.databinding.ItemRecipeBinding
                                                                                 //
class MealAdapter(var requireContext: Context,var meals:ArrayList<ResultX>/*var  onMealClickListener: OnMealClickListener
*/) :
    RecyclerView.Adapter<MealAdapter.ViewHolder>() {


   // private var meals = emptyList<ResultX>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater= LayoutInflater.from(parent.context)
        var binding= ItemRecipeBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val currentItem = meals[position]
        holder.bind(currentItem)


    }

    override fun getItemCount(): Int {
        return meals.size
    }




    fun setMeals() {


      notifyDataSetChanged()
    }



    //ek fragments se dusre fragment me data passing karen ke liye intnet ki jagah bundal ka use karte hai

    private fun pmenudata(position: Int) {

        var item = meals[position]
        var intent=Intent(requireContext,deatils2::class.java)
        intent.putExtra("fimage",item.image)
        intent.putExtra("fname",item.title)
        requireContext.startActivity(intent)

        /*
        val bundle = Bundle().apply {
            putString("fimage", item.image)
            putString("fname", item.title)
        }



      //  val detailsFragment = details().apply {
       val detailsFragment = deatils2().apply {
            arguments = bundle

        }
        detailsFragment.show((requireContext as AppCompatActivity).supportFragmentManager, "details")

         */
    }




    inner class ViewHolder(var binding:ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultX) {
            binding.apply {
                recipeTitle.text=item.title
                Glide.with(itemView.context)
                    .load(item.image)
                    .into(recipeImage)
                /*
                binding.like.setOnClickListener {
                    onMealClickListener.onMealClick(item)
                }

                 */
            }

        }







        //data ko detailas activty me bhej
        init {
            binding.root.setOnClickListener() {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // itemClickListener?.onItemClick(position)
                    pmenudata(position)


                }
            }

        }
        /*
        val mealName: TextView = itemView.findViewById(R.id.meal_name)
        val mealImage: ImageView = itemView.findViewById(R.id.meal_image)

         */

    }

//
interface OnMealClickListener {
    fun onMealClick(meal: ResultX)
}

}