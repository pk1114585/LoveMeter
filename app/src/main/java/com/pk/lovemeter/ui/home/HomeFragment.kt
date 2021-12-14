package com.pk.lovemeter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pk.lovemeter.R
import com.pk.lovemeter.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.go.setOnClickListener(View.OnClickListener {
            getLoveCount()
        })
        return binding.root
    }

    private fun getLoveCount()
    {
        val name1 = binding.yourname.text.toString()
        val name2 = binding.partnername.text.toString()
        homeViewModel.saveInfo(name1,name2)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}