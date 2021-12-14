package com.pk.lovemeter.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    fun saveInfo(name1:String,name2:String)
    {
        _text.value = name1+name2
    }

}