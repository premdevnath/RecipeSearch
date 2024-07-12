package com.example.aiapi.ai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aiapi.MainViewModel
import com.example.aiapi.MealAdapter
import com.example.aiapi.ResultX
import com.example.aiapi.databinding.FragmentBfhomeBinding
import com.example.aiapi.padpter


//kya hua
        //step R1.pahel ek var banaya mainviewmodel jisme dat leke adapter me dal rhe hai
            //(1.1)sabse pahle object class(apiclient)[api se data layga or usme gson fir interface me convert karega]
            //(1.2)interface class banao jisme link ka end point or argu me api key dali

           //(1.3)datbase class banao ()
                 //->1.data class(Resultx)(table ke anadar kay kaya hoga (entity))
                 //->2.dao (database em kaya kay opretion karne hai insert ,update)
          //(1.4)repo class banao jisme sara data hoga fir vo data view model ko diya jayega
          //(1.5)viemodel class banao jo data ko bfhome ko dega

//MainViewModel class local database aur API se data le kar Repository ko deti hai.
//Repository use LiveData mein convert karke ViewModel ko deta hai.
//ViewModel LiveData object (allMeals) ko UI ko observe karne ke liye provide karta hai.
//refreshMeals function network se fresh meals fetch karke local database mein update karta hai







//ya
//room database ke liye->1.dao(interface class jisme database me data add,update,delete karenge)
//menifestfile me name add karo
//QuotesDao

//->2.entity(yani data class)
//Quote

//->3.database
//QuoteDatabase


class bfhome : Fragment()/*,MealAdapter.OnMealClickListener*/ {

    private lateinit var binding: FragmentBfhomeBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mealAdapter: MealAdapter
    private lateinit var adapter: padpter
    lateinit var alldata: ArrayList<ResultX>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBfhomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //

        alldata= ArrayList<ResultX>()

            //yaha viewmodel se sara data liya
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)



       // Log.d("hi", "onViewCreated: hibro")


       // Log.d("hi", "onViewCreated: hibro")
        mainViewModel.allMeals.observe(viewLifecycleOwner, Observer { categoryList ->
            categoryList?.let {

                alldata.clear()
                alldata.addAll(it)
               // adapter.notifyDataSetChanged()
                setadapter(alldata)
                setpopulerad(alldata)
                mealAdapter.setMeals()
                adapter.setMeals()



            }
        })

        mainViewModel.refreshMeals("721e4595904a410491b181dea19f49a1")



        //setserch view
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                setserchview(query)
              return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                setserchview(newText)
               return true
            }

        })





    }




    private fun setserchview(query: String?) {
var searlist=alldata.filter {
    it.title.contains(query!!, ignoreCase = true)==true
}
        setadapter(searlist as ArrayList<ResultX>)

    }



    private fun setadapter(listdata:ArrayList<ResultX>) {
        mealAdapter = MealAdapter(requireContext(),listdata)
        binding.rvi1.adapter=mealAdapter
        binding.rvi1.layoutManager= LinearLayoutManager(requireContext())
    }
    private fun setpopulerad(listdata: ArrayList<ResultX>) {
        //popouler
        adapter= padpter(requireContext(),listdata)
        binding.prvi.adapter=adapter
        binding.prvi.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

    }

    companion object {


    }

    /*
    override fun onMealClick(meal: ResultX) {
       val bundle= Bundle().apply {

           putParcelable("meal",meal)
       }
    }

     */
}