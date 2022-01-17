package com.example.mailfragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mailfragments.R
import com.example.mailfragments.databinding.FragmentSuccessBinding

class SuccessFragment: Fragment() {

    private var _binding: FragmentSuccessBinding? = null
    private val binding: FragmentSuccessBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuccessBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){


            doneBtn.setOnClickListener{
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