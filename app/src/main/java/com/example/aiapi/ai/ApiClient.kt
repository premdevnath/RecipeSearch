package com.example.aiapi.ai

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
1.apilink variable mein Spoonacular API ka base URL store hai.

2.api variable lazy initialization use karta hai, iska matlab hai yeh tab tak initialize nahi hota jab tak use nahi kiya jata.

3.Retrofit.Builder se ek naya Retrofit object banate hain jisme:

->baseUrl(apilink) base URL set kiya jata hai.

->addConverterFactory(GsonConverterFactory.create()) Gson converter factory add ki jati hai taaki JSON responses ko objects mein convert kar sake.
->.build() Retrofit instance build karta hai.
->.create(ApiService::class.java) ApiService interface ka implementation return karta hai.

Toh, jab bhi api ko access karoge, yeh Retrofit instance create karke API calls karne ke liye ready hoga.


 */

object ApiClient {
    var apilink=" https://api.spoonacular.com/"

//s.s.1***(api var ka use karte hi api se data leke use gson me covert kareke usme interface me convert kar diya jayega)
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(apilink)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    /*
    fun getApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(apilink)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

     */
}