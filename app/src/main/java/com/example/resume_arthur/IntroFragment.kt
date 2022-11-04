package com.example.resume_arthur

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.resume_arthur.databinding.FragmentIntroBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class IntroFragment : Fragment()
{

    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    private var dayNightMode = true

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View?
    {
        _binding = FragmentIntroBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?)
    {
        super.onViewCreated(view , savedInstanceState)

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            dayNightMode=!dayNightMode
            binding.apply {
                dayButton.visibility =View.VISIBLE
                nightButton.visibility =View.INVISIBLE
                profileImage.borderColor = Color.WHITE
            }
        } else {
            binding.apply {
                dayButton.visibility =View.GONE
                nightButton.visibility =View.VISIBLE
            }
        }

        binding.apply {
            nightButton.setOnClickListener{
                setDayNightTheme(dayNightMode)
            }
            dayButton.setOnClickListener {
                setDayNightTheme(dayNightMode)
            }
            linkedin.setOnClickListener {
                val linkedInUrl = "https://www.linkedin.com/in/okolo-arthur-56983818b/"
                openSocialLinks(linkedInUrl)
            }
            twitter.setOnClickListener {
                val twitterUrl = "https://twitter.com/Okolo_Arthur"
                openSocialLinks(twitterUrl)
            }
        }
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }

    private fun setDayNightTheme(dayNight : Boolean) {
        if (dayNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Toast.makeText(requireContext(),"Night mode on", Toast.LENGTH_SHORT).show()
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Toast.makeText(requireContext(),"Night mode off", Toast.LENGTH_SHORT).show()
        }
        dayNightMode = !dayNightMode
    }

    private fun openSocialLinks(url: String) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(url)
        startActivity(openURL)
    }
}