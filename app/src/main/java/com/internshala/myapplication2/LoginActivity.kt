package com.internshala.myapplication2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber="0987654321"
    val validPassword = arrayOf("tony","thanos","bruce","steve")
lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedin = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if (isLoggedin){
            val intent =Intent(this@LoginActivity,LoginActivity::class.java)
           startActivity(intent)
            finish()
        }


        title ="Log in"

        etMobileNumber =findViewById(R.id.etMobileNumber)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotPassword=findViewById(R.id.txtForgotPassword)
        txtRegister=findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener {

            val mobileNumber=etMobileNumber.text.toString()
            val password =etPassword.text.toString()
            var nameOfAvenger="Avengers"
            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            if ((mobileNumber==validMobileNumber))
            {
                if(password==validPassword[0]) {

                    nameOfAvenger = "Iron Man"
                    savePreferences(nameOfAvenger)

                    startActivity(intent)

                }
                else if(password==validPassword[1]){

                    nameOfAvenger="Captain America"
                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                }
                else if(password==validPassword[2]){
                    nameOfAvenger="The Hulk"
                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                }
                else if(password==validPassword[3]){
                    nameOfAvenger="The Avengers"
                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                }
            }


            else{
              Toast.makeText(this@LoginActivity,"Incorrect Credentials",Toast.LENGTH_LONG).show()
          }

        }


    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedin",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
