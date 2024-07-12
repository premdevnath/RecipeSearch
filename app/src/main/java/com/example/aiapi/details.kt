package com.example.aiapi

import android.os.Bundle
import com.example.aiapi.databinding.FragmentDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class details : BottomSheetDialogFragment() {

    lateinit var binding:FragmentDetailsBinding
    var foodimage:String?=null
    var foodname:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    /*

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding= FragmentDetailsBinding.inflate(layoutInflater, container, false)

        binding.back.setOnClickListener(){
            dismiss()
        }


//yaha mealadapter ke data ko get kiya
        arguments?.let {
            foodimage = it.getString("fimage")
            foodname = it.getString("fname")
        }

     binding.like.setOnClickListener()
     {
         addcart()
     }

        val ia=foodimage
        val uri =Uri.parse(ia)
        Glide.with(requireContext()).load(uri).into(binding.showimage)
        binding.showname.text=foodname
        //datahshow
        binding.showimage
        return binding.root
    }

    private fun addcart() {
        /*
          var intent= Intent(requireContext(),bffav::class.java)
        intent.putExtra("fname",foodname)
        intent.putExtra("fimage",foodimage)
        startActivity(intent)
        
         */
        val bundle = Bundle().apply {
            putString("fimage", foodimage)
            putString("fname", foodname)
        }
        val bffavFragment = bffav().apply {
            arguments = bundle
        }
        /*
        parentFragmentManager.beginTransaction()
                         //
            .replace(R.id.bffav,bffavFragment)
            .addToBackStack(null)
            .commit()

         */
       // bffavFragment.



    }

    companion object {

    }

     */
}

