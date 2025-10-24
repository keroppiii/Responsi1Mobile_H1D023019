package com.fatimah.responsi1mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fatimah.responsi1mobile.databinding.ActivityCoachBinding

class CoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coachName = intent.getStringExtra("COACH_NAME")
        val coachDob = intent.getStringExtra("COACH_DOB")
        val coachNationality = intent.getStringExtra("COACH_NATIONALITY")

        binding.tvCoachName.text = coachName
        binding.tvCoachDob.text = coachDob
        binding.tvCoachNationality.text = coachNationality

        binding.rootLayout.setOnClickListener {
            if (binding.cardCoachDetails.visibility == View.GONE) {
                showCardWithAnimation()
            }
        }
    }

    private fun showCardWithAnimation() {
        val card = binding.cardCoachDetails
        card.apply {
            alpha = 0f
            visibility = View.VISIBLE

            animate()
                .alpha(1f)
                .setDuration(500)
                .setListener(null)
        }
    }
}