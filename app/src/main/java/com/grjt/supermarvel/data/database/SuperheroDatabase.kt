package com.grjt.supermarvel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grjt.supermarvel.data.database.dao.SuperheroDao
import com.grjt.supermarvel.data.database.entities.SuperheroEntity

@Database(entities = [SuperheroEntity::class], version = 1)
abstract class SuperheroDatabase: RoomDatabase() {

    abstract fun getSuperheroDao(): SuperheroDao

}