package com.pk.lovemeter.ui.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDatabaseDao {

    @Insert
    fun insert(history:UserHistory)

    @Query("Select * from user_history_table")
    fun getAll():List<UserHistory>

    @Delete
    fun delete(history: UserHistory)


}