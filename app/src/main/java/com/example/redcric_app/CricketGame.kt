package com.example.redcric_app

data class CricketGame(
    val tournamentName: String,
    val team1Name: String,
    val team2Name: String,
    val team1FlagResId: Int, // Resource ID for team 1 flag image
    val team2FlagResId: Int, // Resource ID for team 2 flag image
    val megaText: String,
    val croreText: String
)

