package com.pk.lovemeter.ui.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_history_table")
data class UserHistory(
    @PrimaryKey(autoGenerate = true)
    val uid:Int=0,

    @ColumnInfo(name = "username")
    val username:String,

    @ColumnInfo(name = "partnername")
    val partnername:String,

    @ColumnInfo(name = "lovecount")
    val lovecount:Long
)
