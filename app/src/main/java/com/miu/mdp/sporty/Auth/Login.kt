package com.miu.mdp.sporty.Auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.miu.mdp.sporty.Auth.Model.User
import com.miu.mdp.sporty.Auth.Model.UserPreferences
import com.miu.mdp.sporty.MainActivity
import com.miu.mdp.sporty.R

class Login : ComponentActivity() {
    private lateinit var registerButton: Button
    private lateinit var loginButton: Button
    private  lateinit var passwordEditText: EditText
    private  lateinit var emailEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        if(UserPreferences.getAuth(this)!==null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_auth_login)
        loginButton = findViewById<Button>(R.id.loginButton)
        registerButton = findViewById<Button>(R.id.registerButton)
        passwordEditText = findViewById(R.id.passwordEditText)
        emailEditText = findViewById(R.id.emailEditText)
        loginButton.setOnClickListener{

          val password = passwordEditText.text.toString()
            val email = emailEditText.text.toString()

            if( email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all the field", Toast.LENGTH_SHORT).show()
            }else{
                if(!UserPreferences.authUser(this, email,password)){
                    Toast.makeText(this, "Username or password incorrect", Toast.LENGTH_SHORT).show()
                }else{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        registerButton.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}
