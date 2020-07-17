package com.example.task.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.task.data.Experience


@Database(entities = [Experience::class], version = 5)
@TypeConverters(Converter::class)
abstract class DbHelper: RoomDatabase() {

    abstract fun exDao(): ExperienceDao


    companion object {
        private var db: DbHelper? = null


        @Synchronized
        fun getDbInstance(context: Context): DbHelper? {
            if (db == null) {
                db = Room.databaseBuilder(
                    context.applicationContext,
                    DbHelper::class.java,
                    "database_name"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return db
        }
    }



}