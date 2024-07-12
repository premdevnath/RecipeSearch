package com.example.aiapi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.aiapi.databinding.ActivityDeatils2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class deatils2 : AppCompatActivity() {
    lateinit var binding: ActivityDeatils2Binding
    var foodimage:String?=null
    var foodname:String?=null
   // lateinit var sharedViewModel: SharedViewModel
    lateinit var mainViewModel: MainViewModel
   // lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDeatils2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        //
    //    sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        //fav
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.back.setOnClickListener(){
            finish()
        }

      foodimage=  intent.getStringExtra("fimage")
       foodname= intent.getStringExtra("fname")

        binding.showname.text=foodname
        val image=foodimage
        val uri=Uri.parse(image)
        Glide.with(this).load(uri).into(binding.showimage)

        //auth=Firebase.auth
        binding.like.setOnClickListener(){
            addfav()

        }

    }

    private fun addfav() {
       // val currentuser=auth.currentUser?.uid?:""
      //  if (currentuser!=null)}
        foodimage?.let { img ->
            foodname?.let { name ->
                mainViewModel.setFoodData(img?:"", name ?:"")
                Log.d("datade", "addfav:${name} ")
                Log.d("datade", "addfav:${img} ")
            }
        }


    }
}