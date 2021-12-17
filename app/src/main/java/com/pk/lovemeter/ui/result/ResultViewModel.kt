package com.pk.lovemeter.ui.result

import LoveMeterCount
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pk.lovemeter.ui.database.HistoryDatabaseDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ResultViewModel(dataSource:HistoryDatabaseDao): ViewModel() {

    val loveCount:MutableLiveData<Long> by lazy {
        MutableLiveData<Long>()
    }

    fun loadLoveCount(username:String,partnername:String)
    {
        if (loveCount.value==null)
            viewModelScope.launch {
                val count = LoveMeterCount().getLoveCount(username,partnername)

                if (count<50) loveCount.value = count+40 else loveCount.value = count
            }
    }
}