package com.example.aiapi.ai

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aiapi.NetworkUtil
import com.example.aiapi.ResultX
import com.example.aiapi.result
import javax.xml.transform.Result
                 // viewmodel ne call ki


class Repository( private val mealDao: FoodDao,
                  private val applicationContext: Context
) {

//***[yaha fooddao se getmeals fun se data ko liya or vra me dala
    val allMeals: LiveData<List<ResultX>> = mealDao.getMeals()



                     //viewmodel call

    //**[s.s yaha object or interface class se api ka data leke usse fooddao ke addmeals fun ko diya]

    //***[yaha fooddao me object class me bane api var dvara myinterfaceckass ke fun ko call karke data ko response me dala ]
    suspend fun refreshMeals(apiKey: String) {

        if (NetworkUtil.isInternetAvailable(applicationContext)) {
            val response = ApiClient.api.getMeals(apiKey)
            mealDao.addMeals(response.results)
        }
    }

    //*** id ke liye
    suspend fun insertOrUpdateMeal(meal: List<ResultX>) {
        mealDao.insertOrUpdate(meal)
    }


}