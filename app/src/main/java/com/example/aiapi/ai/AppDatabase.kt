package com.example.aiapi.ai

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aiapi.ResultX

//{yaha datbse bana}

//d1 entity= table (data isme table ke from me store hota hai to yaha bantana hai konsi or kitni table hai)
// to yaha ek table hai or vo table yani data class Result hai
@Database(entities = [ResultX::class], version = 1, exportSchema = false)


//d2 yaha pahle Roomdata base ko inherite kiya
abstract class AppDatabase: RoomDatabase() {
    abstract fun foodDao(): FoodDao

    companion object {
        //ye code sabka same ho hoga
        @Volatile
        //d3 yaha ek var banaya jo database type ka hai
        private var INSTANCE: AppDatabase? = null

        //d4 Yeh function getDatabase Room database ka singleton instance return karne ke liye hai. Iska matlab hai ki agar database ka instance pehle se exist karta hai, toh woh return hota hai, aur agar nahi karta, toh naya instance create hota hai

        fun getDatabase(context: Context): AppDatabase {
                            //ye opretor hai (?:)
            return INSTANCE ?: synchronized(this) {
               // return INSTANCE ?: synchronized(this) { ... }: Yeh check karta hai agar INSTANCE null hai, tabhi synchronized block execute hota hai.

                val instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "meal_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}