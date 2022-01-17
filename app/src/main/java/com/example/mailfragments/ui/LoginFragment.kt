package com.example.mailfragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.mailfragments.R
import com.example.mailfragments.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {

    private var emailCheck = "my@email.com"
    private var passwordCheck = "12345"

    private var _binding: FragmentLoginBinding ? = null
    private val binding: FragmentLoginBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            emailEt.editText?.addTextChangedListener { text ->
                signinBtn.isEnabled = text.toString().isNotEmpty()

            }

            signinBtn.setOnClickListener {
                val bundle = Bundle()
                val email  =  emailEt.editText?.text.toString()
                val password =  passwordEt.editText?.text.toString()

                bundle.putString("First", email.toString())
                bundle.putString("password", password.toString())

                val i = if (email == emailCheck && password == passwordCheck) {

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, SuccessFragment::class.java, bundle)
                        .addToBackStack(null)
                        .commit()
                } else {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, FailFragment::class.java, bundle)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }
