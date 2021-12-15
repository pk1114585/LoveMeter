package com.pk.lovemeter.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pk.lovemeter.ui.database.HistoryDatabaseDao
import java.lang.IllegalArgumentException


class ModelFactory(val dataSource:HistoryDatabaseDao) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java))
            return ResultViewModel() as T
        else
            throw IllegalArgumentException("Unknown model class")
    }
}