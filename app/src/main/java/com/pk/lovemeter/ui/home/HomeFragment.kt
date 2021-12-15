package com.pk.lovemeter.ui.home

import LoveMeterCount
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.pk.lovemeter.R
import com.pk.lovemeter.databinding.FragmentHomeBinding
import com.pk.lovemeter.gotosecond
import com.pk.lovemeter.ui.result.ResultFragment

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
           var name:String =binding.yourname.text.toString()
            var partnername:String =binding.partnername.text.toString()
            if (name.isEmpty() && partnername.isEmpty()){
                Toast.makeText(requireContext(),"Text is Empty",Toast.LENGTH_SHORT).show()

            } else if (name.equals(partnername)){
                Toast.makeText(requireContext(),"Both Name can't be same",Toast.LENGTH_SHORT).show()

            }

            else{
              var result:Long= LoveMeterCount().getLoveCount(name,partnername)
               var resultFragment= ResultFragment()


                var bundle=Bundle()
                bundle.putLong("resultno" ,result)
                resultFragment.arguments.to(bundle)

                getLoveCount()
            }




        })
        return binding.root
    }

    private fun getLoveCount()
    {
        val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
        navController?.navigate(R.id.action_nav_home_to_resultFragment)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}