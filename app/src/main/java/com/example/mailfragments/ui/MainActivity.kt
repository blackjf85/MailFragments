package com.example.mailfragments.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mailfragments.R

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, LoginFragment())
                .commit()
        }
    }
}
