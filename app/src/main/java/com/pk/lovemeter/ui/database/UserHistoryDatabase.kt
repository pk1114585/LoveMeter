package com.pk.lovemeter.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserHistory::class], version = 1)
abstract class UserHistoryDatabase :RoomDatabase(){
    abstract val userHistoryDatabaseDao:HistoryDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE:UserHistoryDatabase? = null
        fun getInstance(context: Context):UserHistoryDatabase
        {
            synchronized(this){
                var instance = INSTANCE
                if (instance==null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserHistoryDatabase::class.java,
                        "UserHistory"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}