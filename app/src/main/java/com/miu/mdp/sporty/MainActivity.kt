package com.miu.mdp.sporty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.miu.mdp.sporty.Adapters.FragmentPageAdapter
import com.miu.mdp.sporty.Pages.AboutMe.AboutMeFragment
import com.miu.mdp.sporty.Pages.Athletes.AthletesFragment
import com.miu.mdp.sporty.Pages.Events.EventsFragment
import com.miu.mdp.sporty.Pages.HistoricalActivity.HistoricalSportsAchiveFragment
import com.miu.mdp.sporty.Pages.News.NewsFragment
import com.miu.mdp.sporty.Pages.Sports.SportsFragment
import com.miu.mdp.sporty.ui.theme.SportyTheme

class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)

        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_news -> {
                    tab.selectTab(tab.getTabAt(1))
                    true
                }

                R.id.navigation_event -> {
                    tab.selectTab(tab.getTabAt(3))
                    true
                }

                R.id.navigation_historical_archive -> {
                    tab.selectTab(tab.getTabAt(4))
                    true
                }

                else -> { true}
            }
        }


        // Initializing the ViewPagerAdapter
        val adapter = FragmentPageAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(SportsFragment(), "Sports")
        adapter.addFragment(NewsFragment(), "News")
        adapter.addFragment(AthletesFragment(), "Athletes")
        adapter.addFragment(EventsFragment(), "Events")
        adapter.addFragment(HistoricalSportsAchiveFragment(), "Historical Archives")
        adapter.addFragment(AboutMeFragment(), "About Me")

//        0 - SportsFragment
//        1 - NewsFragment
//        2 - AthletesFragment
//        3 - EventsFragment
//        4 - HistoricalSportsAchiveFragment
//        5 - AboutMeFragment
        // Adding the Adapter to the ViewPager
        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)
    }
}
