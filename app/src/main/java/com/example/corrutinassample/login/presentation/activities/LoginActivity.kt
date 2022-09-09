package com.example.corrutinassample.login.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.corrutinassample.databinding.ActivityLoginBinding
import com.example.corrutinassample.main.presentation.activities.MainActivity

class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    //private lateinit var btnAut:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLoaders()

    }

    private fun initLoaders() {
        binding.run {
            btnAut.setOnClickListener{
                val explicitIntent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(explicitIntent)

                //val explicitService = Intent()
            }
        }
    }
}