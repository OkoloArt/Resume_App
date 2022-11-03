package com.example.resume_arthur

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.resume_arthur.adapter.ResumePagerAdapter
import com.example.resume_arthur.databinding.ActivityMainBinding
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(null)

        binding.indicatorView.apply {
            setSliderWidth(resources.getDimension(R.dimen.dp_10))
            setSliderHeight(resources.getDimension(R.dimen.dp_5))
            setSlideMode(IndicatorSlideMode.NORMAL)
            setIndicatorStyle(IndicatorStyle.CIRCLE)
            setupWithViewPager(binding.viewPager)
        }
        val resumePagerAdapter = ResumePagerAdapter(this, this)
        binding.viewPager.adapter = resumePagerAdapter
    }
}