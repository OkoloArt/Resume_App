package com.example.resume_arthur.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resume_arthur.databinding.SkillsListDetailsBinding
import com.example.resume_arthur.model.Skills

class ResumeAdapter(
    private val context: Context ,
    private val dataSet: List<Skills> ,
) : RecyclerView.Adapter<ResumeAdapter.SkillsViewHolder>() {


    class SkillsViewHolder(private val binding: SkillsListDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(skills: Skills) {
            binding.skillsTitle.text = skills.skillName
            binding.skillsIcon.setImageResource(skills.skillIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): SkillsViewHolder {
        return SkillsViewHolder(
                SkillsListDetailsBinding.inflate(
                        LayoutInflater.from(
                                parent.context
                        )
                )
        )
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        val current = dataSet[position]
        holder.bind(current)
    }

    override fun getItemCount() = dataSet.size
}