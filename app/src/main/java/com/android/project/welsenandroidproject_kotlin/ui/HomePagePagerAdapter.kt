package com.android.project.welsenandroidproject_kotlin.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.project.welsenandroidproject_kotlin.ui.event_history.EventHistoryFragment
import com.android.project.welsenandroidproject_kotlin.ui.rocket_history.RocketHistoryFragment

class HomePagePagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> RocketHistoryFragment()
            else -> EventHistoryFragment()
        }
    }

}