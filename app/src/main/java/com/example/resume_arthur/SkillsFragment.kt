package com.example.resume_arthur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.resume_arthur.adapter.ResumeAdapter
import com.example.resume_arthur.databinding.FragmentSkillsBinding
import com.example.resume_arthur.model.DataSource

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SkillsFragment : Fragment()
{

    private var _binding: FragmentSkillsBinding? = null
    val skillList = DataSource().loadSkills()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View?
    {

        _binding = FragmentSkillsBinding.inflate(inflater , container , false)
        return binding.root

    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?)
    {
        super.onViewCreated(view , savedInstanceState)

       binding.skillsRecyclerview.apply {
           layoutManager = GridLayoutManager(requireContext() , 2 , GridLayoutManager.VERTICAL , false)
           adapter = ResumeAdapter(requireContext(), skillList)
           setHasFixedSize(true)
       }
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }
}