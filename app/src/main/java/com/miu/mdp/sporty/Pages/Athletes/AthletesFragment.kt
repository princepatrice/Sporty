package com.miu.mdp.sporty.Pages.Athletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miu.mdp.sporty.R

/**
 * A simple [Fragment] subclass.
 * Use the [AthletesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AthletesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_athletes, container, false)
    }
}