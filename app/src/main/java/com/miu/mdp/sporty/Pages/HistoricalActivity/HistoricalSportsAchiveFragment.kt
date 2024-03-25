package com.miu.mdp.sporty.Pages.HistoricalActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miu.mdp.sporty.R

// TODO: Rename parameter arguments, choose names that match
/**
 * A simple [Fragment] subclass.
 * Use the [HistoricalSportsAchiveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoricalSportsAchiveFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historical_sports_achive, container, false)
    }

}