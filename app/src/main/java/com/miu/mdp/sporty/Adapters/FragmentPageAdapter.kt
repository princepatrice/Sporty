package com.miu.mdp.sporty.Adapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


interface DialogCallback {
    fun onDataReturned(data: Any)
}

interface FragmentActions:DialogCallback {
    fun openDialog()
}
// Define an abstract class that implements the interface
abstract class BaseFragment : Fragment(), FragmentActions {
}
class FragmentPageAdapter(supportFragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(supportFragmentManager) {
        // declare arrayList to contain fragments and its title
        private val sportyFragmentList = ArrayList<BaseFragment>()
        private val sportyFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): BaseFragment {
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

        fun addFragment(fragment: BaseFragment, title: String) {
            // add each fragment and its title to the array list
            sportyFragmentList.add(fragment)
            sportyFragmentTitleList.add(title)
        }
}
