package com.example.resume_arthur.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.resume_arthur.IntroFragment
import com.example.resume_arthur.SkillsFragment

class ResumePagerAdapter(fragmentActivity: FragmentActivity, private val context: Context) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment
    {
        return when (position) {
            0 -> IntroFragment()
            else -> SkillsFragment()
        }
    }

}