package com.example.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvc.databinding.ActivityMainBinding
import com.example.mvc.ui.Controller

private lateinit var binding: ActivityMainBinding
private val controller: Controller = Controller()


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        val userName = binding.usernameEdittext
        val userPassword = binding.passwordEdittext

        binding.btnLogin.setOnClickListener {
            if (controller.login(userName.text.toString(), userPassword.text.toString()) == 1) {
                Toast.makeText(this, "Login Succeeded", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}