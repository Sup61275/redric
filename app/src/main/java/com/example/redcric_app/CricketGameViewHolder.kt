package com.example.redcric_app

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CricketGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(game: CricketGame) {

    }

    val tournamentNameTextView: TextView = itemView.findViewById(R.id.tvT20WorldCup)
    val team1TextView: TextView = itemView.findViewById(R.id.engTextView)
    val team1FlagImageView: ImageView = itemView.findViewById(R.id.engFlagImageView)
    val team2TextView: TextView = itemView.findViewById(R.id.indTextView)
    val team2FlagImageView: ImageView = itemView.findViewById(R.id.indFlagImageView)
    val megaTextView: TextView = itemView.findViewById(R.id.tvMega)
    val croreTextView: TextView = itemView.findViewById(R.id.tv50Crore)
}
