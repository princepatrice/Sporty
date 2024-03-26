package com.miu.mdp.sporty.Pages.Sports

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.sporty.Pages.Sports.Model.Sport
import com.miu.mdp.sporty.R

public class SportAdapter (private val context: Context, private val rubriques: List<Sport>) :
    RecyclerView.Adapter<SportAdapter.RubriqueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RubriqueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport_layout, parent, false)
        return RubriqueViewHolder(view)
    }

    override fun onBindViewHolder(holder: RubriqueViewHolder, position: Int) {
        val rubrique = rubriques[position]
        holder.bind(rubrique)
    }

    override fun getItemCount(): Int {
        return rubriques.size
    }

    inner class RubriqueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sportTypeTextView: TextView = itemView.findViewById(R.id.text_sport_type)
        private val sportNameTextView: TextView = itemView.findViewById(R.id.text_sport_name)
        private val instructionTextView: TextView = itemView.findViewById(R.id.text_instruction)

        fun bind(sport: Sport) {
            sportTypeTextView.text = sport.sportType
            sportNameTextView.text = sport.sportName
            instructionTextView.text = sport.instruction
        }
    }
}

