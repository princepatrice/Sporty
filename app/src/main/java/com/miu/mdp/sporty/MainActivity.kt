package com.miu.mdp.sporty

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.miu.mdp.athletey.Pages.Athletes.AthleteFragment
import com.miu.mdp.eventy.Pages.Events.EventFragment
import com.miu.mdp.historicalActivityy.Pages.HistoricalActivity.HistoricalActivityFragment
import com.miu.mdp.newsy.Pages.News.NewsFragment
import com.miu.mdp.sporty.Adapters.FragmentPageAdapter
import com.miu.mdp.sporty.Pages.AboutMe.AboutMeFragment
import com.miu.mdp.sporty.Pages.Sports.SportsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        fab = findViewById(R.id.fab_add)

        // Initializing the ViewPagerAdapter
        val adapter = FragmentPageAdapter(supportFragmentManager)
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
        fab.setOnClickListener {
            val selectedFragment = tab.selectedTabPosition
            print("selected Fragmeent ")
            print(selectedFragment)
            adapter.getItem(selectedFragment).openDialog()
        }



        // add fragment to the list
        adapter.addFragment(SportsFragment(), "Sports")
        adapter.addFragment(NewsFragment(), "News")
        adapter.addFragment(AthleteFragment(), "Athletes")
        adapter.addFragment(EventFragment(), "Events")
        adapter.addFragment(HistoricalActivityFragment(), "Historical Archives")
        adapter.addFragment(AboutMeFragment(), "About Me")

//        0 - SportsFragment
//        1 - NewsFragment
//        2 - AthleteFragment
//        3 - EventFrgment
//        4 - HistoricalSportsAchiveFragment
//        5 - AboutMeFragment
        // Adding the Adapter to the ViewPager
        pager.adapter = adapter
        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(currenttab: TabLayout.Tab?) {
                if (currenttab?.position == 5) { // Replace YOUR_SPECIFIC_TAB_POSITION with the position of the tab where you want to hide the button
                    fab.visibility = View.GONE // Set the button to be not visible
                } else {
                    fab.visibility = View.VISIBLE // Set the button to be visible for other tabs
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }

}
