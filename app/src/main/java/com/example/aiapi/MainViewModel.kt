package com.example.aiapi

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aiapi.ai.AppDatabase
import com.example.aiapi.ai.CategoryList
import com.example.aiapi.ai.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



//***[yaha api or datbase ke data ko lene ke liye liye alag se application class nhi banai or viewmodel me hi datbse or or api ke dal]

                           //yaha viewmodel datbase or api se data leke pahle repo ko de rha hai or ir repo use live data me convert karke viewmodel ko de rhi hai
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository
    val allMeals: LiveData<List<ResultX>>

    //fav
    val foodData = MutableLiveData<Pair<String, String>>()

                           //    val foodData: LiveData<Pair<String, String>> get() = _foodData

    //  [to ye init corutine hai]
    init {

        //yaha mealdao me api or dataabse dono ka data liya
        // 1.(AppDatabase.getDatabase(application)) database ka data
       //2. foodDao() api ka data liya(*3 rule)
        val mealDao = AppDatabase.getDatabase(application).foodDao()
                     //yaha call hui hai repo
        //fir is data ko repo ko diya jisne use live data me convert karke vapas diya reposirty me
        //(fir is data ko bfhome ko diya)
                                       //
        repository = Repository(mealDao, application)
        allMeals = repository.allMeals
    }


                               fun insertOrUpdateMeal(meal:List< ResultX>) = viewModelScope.launch {
                                   repository.insertOrUpdateMeal(meal)
                               }



                               fun refreshMeals(apiKey: String) = viewModelScope.launch {
        repository.refreshMeals(apiKey)
    }

                               //fav

                               fun setFoodData(image: String, name: String) {
                                   foodData.value = Pair(image, name)
                                   Log.d("datav", "${image} ")
                                   Log.d("SharedViewModel", "setFoodData called with image: $image and name: $name")
                               }

}