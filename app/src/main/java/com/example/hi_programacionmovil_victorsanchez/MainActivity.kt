package com.example.hi_programacionmovil_victorsanchez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hi_programacionmovil_victorsanchez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var etUser:EditText = binding.etUser
        var etPsw:EditText = binding.etPsw

        val btnLogin: Button = binding.btnLogin
        btnLogin.setOnClickListener() {

            if(etUser.toString()!="" && etPsw.toString()!="")
                Toast.makeText(this, "Debes poner un usuario y una contraseña", Toast.LENGTH_SHORT).show()
            else{
                val intent = Intent(this, Formulario::class.java)
                startActivity(intent)
            }

        }



    }
}