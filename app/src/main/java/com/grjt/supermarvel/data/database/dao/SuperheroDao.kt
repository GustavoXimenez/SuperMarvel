package com.grjt.supermarvel.data.database.dao

import androidx.room.*
import com.grjt.supermarvel.data.database.entities.SuperheroEntity

@Dao
interface SuperheroDao {

    @Query("SELECT * FROM superhero_table")
    suspend fun getAllSuperHero():List<SuperheroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(superheroList: List<SuperheroEntity>)

    @Query("DELETE FROM superhero_table")
    suspend fun clearSuperheroes()

}