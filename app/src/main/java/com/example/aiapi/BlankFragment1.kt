package com.example.aiapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aiapi.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {

  //  lateinit var foodImage:ArrayList<String>
    //lateinit var foodName:ArrayList<String>
    lateinit var adapter:newadapter
    lateinit var binding: FragmentBlank1Binding
    lateinit var mainViewModel: MainViewModel

   // private lateinit var sharedViewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBlank1Binding.inflate(layoutInflater, container, false)
        Log.d("hilil1", "onCreateView: ")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //                               //r
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        Log.d("hilil2", "onCreateView: ")
/*
        adapter= newadapter(requireContext())
        binding.frvi.adapter = adapter
        binding.frvi.layoutManager = LinearLayoutManager(requireContext())

 */
        /*
        sharedViewModel.foodData.observe(viewLifecycleOwner, Observer { data ->
            Log.d("hilil3", "onCreateView: ")
            Log.d("FragmentObserver", "Observer triggered with data: $data")
            data.let {
                // adapter.setMeals(data.first, data.second)

                Log.d("hilil4", "onCreateView: ")
                               //
                foodImage.add(it.first)
                foodName.add(it.second)
                Log.d("data2", "addfav:${foodImage} ")
                Log.d("data2", "addfav:${foodName} ")

                if (::adapter.isInitialized) {
                    adapter.notifyDataSetChanged()
                    adapter.setMeals()
                } else {
                    setadapter()

                }

            }
        })



         */


        //error
        /*
        mainViewModel.foodData.observe(viewLifecycleOwner, Observer { data ->
            data.let {

                adapter.setMeals(it.first, it.second)
                Log.d("hilil3", "onCreateView: ")
                Log.d("Fragment", "Observer triggered with image: ${it.first} and name: ${it.second}")
            }
        })

         */
        mainViewModel.foodData.observe(viewLifecycleOwner, Observer { data ->
            try {
                data?.let {
                    adapter.setMeals(it.first, it.second)

                    setadapter()
                    Log.d("Fragment", "Observer triggered with image: ${it.first} and name: ${it.second}")
                } ?: run {
                    Log.d("Fragment", "Data is null")
                }
            } catch (e: Exception) {
                Log.e("Fragment", "Error in observer: ${e.message}", e)
            }
        })


    }

    private fun setadapter() {
        Log.d("hilil5", "onCreateView: ")

       adapter= newadapter(requireContext())
        binding.frvi.adapter = adapter
        binding.frvi.layoutManager = LinearLayoutManager(requireContext())



    }



    companion object {

    }
}