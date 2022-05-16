package com.example.koksharovconsult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.koksharovconsult.Retrofit.myRetrofit
import retrofit2.Call
import retrofit2.Response

lateinit var email:EditText;
lateinit var pass:EditText;
//
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email=findViewById(R.id.editTextTextEmailAddress)
        pass=findViewById(R.id.editTextTextPassword)
    }

    fun onLoginClick(view: android.view.View) {
        val retrofit=myRetrofit.getRetrofit()
        val hashMap:HashMap<String, String> =HashMap<String, String>()
        hashMap["e-mail"]=email.text.toString()
        hashMap["password"]= pass.text.toString()
        val call: Call<login> = retrofit.login(hashMap)
        call.enqueue(object: retrofit2.Callback<login>{
            override fun onResponse(call: retrofit2.Call<login>, response: Response<login>) {
                if (response.body()?.token!=0) {
                    login.userToken=response.body()?.token
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
                else AlertDialog.Builder(this@LoginActivity).setMessage("Ошибка").show()
            }

            override fun onFailure(call: retrofit2.Call<login>, t: Throwable) {
                val toast= Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })

        if (email.text.toString().isEmpty() && pass.text.toString().isEmpty()) {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незавершённое поле")
                .setPositiveButton("ОК", null)
                .create()
                .show()
        }
        else {
            val intent= Intent(this, FoodChoiceActivity::class.java)
            startActivity(intent)
        }
        }
    }