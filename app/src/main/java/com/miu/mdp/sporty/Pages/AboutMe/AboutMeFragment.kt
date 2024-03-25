package com.miu.mdp.sporty.Pages.AboutMe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miu.mdp.sporty.R

/**
 * A simple [Fragment] subclass.
 * Use the [AboutMeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutMeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_me, container, false)
    }
}