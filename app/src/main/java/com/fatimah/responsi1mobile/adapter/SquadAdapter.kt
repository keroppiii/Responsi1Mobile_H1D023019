package com.fatimah.responsi1mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fatimah.responsi1mobile.R
import com.fatimah.responsi1mobile.data.Squad

class SquadAdapter(
    private val context: Context,
    private val squadList: List<Squad>,
    private val listener: (Squad) -> Unit
) : RecyclerView.Adapter<SquadAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardPlayer: CardView = view.findViewById(R.id.card_player)
        val tvPlayerName: TextView = view.findViewById(R.id.tv_player_name)
        val tvPlayerNationality: TextView = view.findViewById(R.id.tv_player_nationality)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_player, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return squadList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = squadList[position]

        holder.tvPlayerName.text = player.name
        holder.tvPlayerNationality.text = player.nationality

        val cardColor = when {
            player.position?.contains("Goalkeeper", ignoreCase = true) == true ->
                R.color.player_yellow

            player.position?.contains("Defen", ignoreCase = true) == true ||
                    player.position?.contains("Back", ignoreCase = true) == true ->
                R.color.player_blue

            player.position?.contains("Midfield", ignoreCase = true) == true ->
                R.color.player_green

            player.position?.contains("Forward", ignoreCase = true) == true ||
                    player.position?.contains("Offence", ignoreCase = true) == true ||
                    player.position?.contains("Winger", ignoreCase = true) == true ->
                R.color.player_red

            else ->
                android.R.color.white
        }
        holder.cardPlayer.setCardBackgroundColor(ContextCompat.getColor(context, cardColor))

        holder.itemView.setOnClickListener {
            listener(player)
        }
    }
}