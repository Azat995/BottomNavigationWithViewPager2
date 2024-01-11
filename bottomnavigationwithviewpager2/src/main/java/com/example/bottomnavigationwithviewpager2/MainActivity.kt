package com.example.bottomnavigationwithviewpager2

import android.content.res.Resources.NotFoundException
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomnavigationwithviewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigation()
        setViewPager()
    }

    private fun setBottomNavigation() {
        binding.navView.apply {
            setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.navigation_home -> changeTabPosition(ViewPagerPage.HOME)
                    R.id.navigation_dashboard -> changeTabPosition(ViewPagerPage.DASHBOARD)
                    R.id.navigation_notifications -> changeTabPosition(ViewPagerPage.NOTIFICATIONS)
                    R.id.navigation_settings -> changeTabPosition(ViewPagerPage.SETTINGS)
                    else -> throw NotFoundException("itemId not found")
                }
                return@setOnItemSelectedListener true
            }
        }
    }

    private fun changeTabPosition(page: ViewPagerPage) {
        binding.viewPager.setCurrentItem(page.position, true)
    }

    private fun setViewPager() = with(binding.viewPager) {
        mainPagerAdapter = MainPagerAdapter(this@MainActivity)
        isUserInputEnabled = true
        adapter = mainPagerAdapter
        offscreenPageLimit = mainPagerAdapter.itemCount
        registerOnPageChangeCallback(pageChangedCallback)
    }

    private val pageChangedCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            binding.navView.menu.getItem(position).isChecked = true
        }
    }
}