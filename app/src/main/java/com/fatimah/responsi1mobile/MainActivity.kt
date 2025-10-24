package com.fatimah.responsi1mobile

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fatimah.responsi1mobile.data.Squad
import com.fatimah.responsi1mobile.databinding.ActivityMainBinding
import com.fatimah.responsi1mobile.viewmodel.MainViewModel
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val API_KEY = "71a458cee55848088c284cd39ba363f9"
    private val TEAM_ID = 86

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observeViewModel()
        viewModel.fetchTeamDetails(TEAM_ID, API_KEY)

        binding.cardHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.cardCoach.setOnClickListener {
            val coach = viewModel.teamData.value?.coach
            if (coach != null) {
                val intent = Intent(this, CoachActivity::class.java).apply {
                    putExtra("COACH_NAME", coach.name)
                    putExtra("COACH_DOB", coach.dateOfBirth)
                    putExtra("COACH_NATIONALITY", coach.nationality)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Coach data not available.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cardSquad.setOnClickListener {
            val squadList = viewModel.teamData.value?.squad
            if (!squadList.isNullOrEmpty()) {
                val intent = Intent(this, SquadActivity::class.java).apply {
                    putParcelableArrayListExtra("SQUAD_LIST", ArrayList(squadList))
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Squad data not available.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        viewModel.teamData.observe(this) { teamData ->
            if (teamData != null) {
                binding.tvClubName.text = teamData.name

                binding.tvClubHistoryDescription.text = getString(R.string.madrid_short_desc)

                Glide.with(this)
                    .load(teamData.crest)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.imgClubLogo)

                Glide.with(this)
                    .load(R.drawable.stadium_bernabeu)
                    .centerCrop()
                    .into(binding.imgHeader)
            }
        }

        viewModel.errorMessage.observe(this) { message ->
            if (message != null) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }
    }
}