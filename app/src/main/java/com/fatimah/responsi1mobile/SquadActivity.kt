package com.fatimah.responsi1mobile

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatimah.responsi1mobile.adapter.SquadAdapter
import com.fatimah.responsi1mobile.data.Squad
import com.fatimah.responsi1mobile.databinding.ActivitySquadBinding
import com.fatimah.responsi1mobile.fragment.PlayerDetailFragment

class SquadActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySquadBinding
    private lateinit var squadAdapter: SquadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Team Squad"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val squadList: ArrayList<Squad>? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableArrayListExtra("SQUAD_LIST", Squad::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableArrayListExtra("SQUAD_LIST")
        }

        if (squadList != null) {
            squadAdapter = SquadAdapter(this, squadList) { player ->
                PlayerDetailFragment.newInstance(player)
                    .show(supportFragmentManager, "PlayerDetailFragment")
            }

            binding.recyclerViewSquad.apply {
                layoutManager = LinearLayoutManager(this@SquadActivity)
                adapter = squadAdapter
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}