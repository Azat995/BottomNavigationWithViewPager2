package com.example.bottomnavigationwithviewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bottomnavigationwithviewpager2.ui.dashboard.DashboardFragment
import com.example.bottomnavigationwithviewpager2.ui.home.HomeFragment
import com.example.bottomnavigationwithviewpager2.ui.notifications.NotificationsFragment
import com.example.bottomnavigationwithviewpager2.ui.settings.SettingsFragment

class MainPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = ViewPagerPage.values().size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            ViewPagerPage.HOME.position -> HomeFragment()
            ViewPagerPage.DASHBOARD.position -> DashboardFragment()
            ViewPagerPage.NOTIFICATIONS.position -> NotificationsFragment()
            ViewPagerPage.SETTINGS.position -> SettingsFragment()
            else -> throw IllegalStateException()
        }
    }
}

enum class ViewPagerPage(val position: Int) {
    HOME(0),
    DASHBOARD(1),
    NOTIFICATIONS(2),
    SETTINGS(3)
}