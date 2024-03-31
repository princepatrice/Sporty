package com.miu.mdp.sporty.Auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.sporty.Auth.Model.UserPreferences
import com.miu.mdp.sporty.MainActivity
import com.miu.mdp.sporty.R
import android.content.Context
import android.widget.Toast
import com.miu.mdp.sporty.Auth.Model.User

class Register : AppCompatActivity() {
    private lateinit var registerButton: Button
    private lateinit var loginButton: Button
    
    private  lateinit var usernameEditText: EditText
    private  lateinit var passwordEditText: EditText
    private  lateinit var emailEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_auth_register)
        loginButton = findViewById<Button>(R.id.loginButton)
        registerButton = findViewById<Button>(R.id.registerButton)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        emailEditText = findViewById(R.id.emailEditText)
        loginButton.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener{
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val email = emailEditText.text.toString()

            if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all the field", Toast.LENGTH_SHORT).show()
            }else{
                if(UserPreferences.userExists(this,email)){
                    Toast.makeText(this, "This User Already Exist", Toast.LENGTH_SHORT).show()
                }else{
                    UserPreferences.addUser(this, User(email,username,password, ""))
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }


        }


    }
}
