package com.miu.mdp.sporty.Pages.AboutMe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.miu.mdp.sporty.Adapters.BaseFragment
import com.miu.mdp.sporty.Auth.Login
import com.miu.mdp.sporty.Auth.Model.User
import com.miu.mdp.sporty.Auth.Model.UserPreferences
import com.miu.mdp.sporty.R

/**
 * A simple [Fragment] subclass.
 * Use the [AboutMeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutMeFragment : BaseFragment() {
    private lateinit var logout: Button
    override fun openDialog() {

    }

    override fun onDataReturned(data: Any) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_me, container, false)
        logout = view.findViewById(R.id.logoutButton)
        if (container != null) {

            val user = UserPreferences.getAuth(container.context)
            val emailText = view.findViewById<TextView>(R.id.emailTextView)
            val usernameText = view.findViewById<TextView>(R.id.usernameTextView)

            emailText.setText(user?.email)
            usernameText.setText(user?.username)

            logout.setOnClickListener {
                UserPreferences.un_auth(container.context)
                val intent = Intent(container.context, Login::class.java)
                startActivity(intent)
            }

        }

        return view
    }
}