package com.miu.mdp.sporty.Adapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentPageAdapter(supportFragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(supportFragmentManager) {
        // declare arrayList to contain fragments and its title
        private val sportyFragmentList = ArrayList<Fragment>()
        private val sportyFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            // return a particular fragment page
            return sportyFragmentList[position]
        }

        override fun getCount(): Int {
            // return the number of tabs
            return sportyFragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence{
            // return title of the tab
            return sportyFragmentTitleList[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            // add each fragment and its title to the array list
            sportyFragmentList.add(fragment)
            sportyFragmentTitleList.add(title)
        }
}
