package com.pk.lovemeter.ui.home

import LoveMeterCount
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.pk.lovemeter.R
import com.pk.lovemeter.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

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
           val name:String =binding.yourname.text.toString()
            val partnernamedata:String =binding.partnername.text.toString()
            if (name.isEmpty() && partnernamedata.isEmpty()){
                Toast.makeText(requireContext(),"Text is Empty",Toast.LENGTH_SHORT).show()

            } else if (name.equals(partnernamedata)){
                Toast.makeText(requireContext(),"Both Name can't be same",Toast.LENGTH_SHORT).show()

            }else if (name.isBlank())
            {
                yourname.error="it can't be blank"

            }

            else if (partnernamedata.isBlank())
            {
                partnername.error="it can't be blank"

            }


            else{
                getLoveCount(name,partnernamedata)
            }




        })
        return binding.root
    }

    private fun getLoveCount(username:String,partnername:String)
    {
        val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
        val bundle = bundleOf("username" to username,"partnername" to partnername)
        navController?.navigate(R.id.action_nav_home_to_resultFragment,bundle)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}