package com.pk.lovemeter.ui.result

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pk.lovemeter.R
import com.pk.lovemeter.ui.database.HistoryDatabaseDao
import com.pk.lovemeter.ui.database.UserHistoryDatabase
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val username = arguments?.getString("username")
        val partnername = arguments?.getString("partnername")
        Log.i("Result",username.toString()+partnername)

//        val dataSource = UserHistoryDatabase.getInstance(requireContext()).userHistoryDatabaseDao
//        val factory = ModelFactory(dataSource)
        val viewModel = ViewModelProvider(this)[ResultViewModel::class.java]

        if (partnername != null&& username!=null) {
            viewModel.loadLoveCount(username,partnername)
        }
        viewModel.loveCount.observe(viewLifecycleOwner, Observer {
            val tv = resultdata
            tv.setText(viewModel.loveCount.value.toString() +"%")
        })
        Log.i("result","onCreateView")
        return inflater.inflate(R.layout.fragment_result, container, false)

    }


}