package com.example.aiapi.ai


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.aiapi.ResultX

//yaha datbse me data insert kar rhe hai
@Dao
interface FoodDao {

    //Insert operation me OnConflictStrategy.REPLACE ka use karein jisse ki agar primary key conflict ho to purana record replace ho jaye.
    //kotlin


              //ye har bar qnic id banayega same id nhi banae dega
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMeals(meals: List<ResultX>)

    //ye kiya taki har bar id uapdate hoti rhe
    @Update
    suspend fun update(meals: List<ResultX>)



    @Query("SELECT * FROM meal_table")
    fun getMeals(): LiveData<List<ResultX>>



    //*3 rule
    //yaha api se sara data is fun ne liya or us data ko live datake room me return kiya
    //[ Ye method ek LiveData object return karta hai jo data change hone par automatically UI ko update karta hai.]
    @Query("SELECT * FROM meal_table WHERE id = :id")
 fun getMealById(id: Int):LiveData<List<ResultX>>


  //
 /*
  @Transaction
  suspend fun insertOrUpdate(meal: List<ResultX>) {
      val existingMeal = getMeals(meal.id)
      if (existingMeal != null) {
          update(meal)
      } else {
          addMeals(meal)
      }
  }

  */
    @Transaction
    suspend fun insertOrUpdate(meals: List<ResultX>) {
        meals.forEach { meal ->
            val existingMeal = getMealById(meal.id)
            if (existingMeal == null) {
                addMeals(listOf(meal))
            } else {
                update(listOf(meal))
            }
        }

}
}
