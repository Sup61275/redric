package com.example.redcric_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CricketGameAdapter(private val cricketGames: List<CricketGame>) :
    RecyclerView.Adapter<CricketGameViewHolder>() {

    // Change this variable to control the number of times the CardView should be repeated
    private val repeatCount = 9

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketGameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return CricketGameViewHolder(view)
    }

    override fun onBindViewHolder(holder: CricketGameViewHolder, position: Int) {
        // Get the correct game based on the position within the repeating sequence
        val game = cricketGames[position % cricketGames.size]

        holder.tournamentNameTextView.text = game.tournamentName
        holder.team1TextView.text = game.team1Name
        holder.team1FlagImageView.setImageResource(game.team1FlagResId)
        holder.team2TextView.text = game.team2Name
        holder.team2FlagImageView.setImageResource(game.team2FlagResId)
        holder.megaTextView.text = game.megaText
        holder.croreTextView.text = game.croreText
    }

    override fun getItemCount(): Int {
        // Return the total number of items as the product of the cricket games and the repeat count
        return cricketGames.size * repeatCount
    }
}
