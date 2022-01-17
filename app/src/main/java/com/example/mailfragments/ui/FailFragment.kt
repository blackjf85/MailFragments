package com.example.mailfragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mailfragments.R
import com.example.mailfragments.databinding.FragmentFailBinding

class FailFragment: Fragment() {
    private var _binding: FragmentFailBinding? = null
    private val binding: FragmentFailBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentFailBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){


            errorBtn.setOnClickListener{
                val bundle = Bundle()



                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, LoginFragment::class.java, bundle)
                    .addToBackStack(null)
                    .commit()

            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}