package com.example.koksharovconsult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

lateinit var email:EditText;
lateinit var pass:EditText;

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email=findViewById(R.id.editTextTextEmailAddress)
        pass=findViewById(R.id.editTextTextPassword)
    }

    fun onLoginClick(view: android.view.View) {
        if (email.text.toString().isEmpty() && pass.text.toString().isEmpty()) {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незавершённое поле")
                .setPositiveButton("ОК", null)
                .create()
                .show()
        }
    }
}