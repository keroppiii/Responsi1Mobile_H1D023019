package com.fatimah.responsi1mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fatimah.responsi1mobile.data.Squad
import com.fatimah.responsi1mobile.databinding.FragmentPlayerDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlayerDetailFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString(ARG_NAME)
        val dob = arguments?.getString(ARG_DOB)
        val nationality = arguments?.getString(ARG_NATIONALITY)
        val position = arguments?.getString(ARG_POSITION)

        binding.tvDetailPlayerName.text = name
        binding.tvDetailPlayerDob.text = dob
        binding.tvDetailPlayerNationality.text = nationality
        binding.tvDetailPlayerPosition.text = position
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        private const val ARG_NAME = "player_name"
        private const val ARG_DOB = "player_dob"
        private const val ARG_NATIONALITY = "player_nationality"
        private const val ARG_POSITION = "player_position"

        fun newInstance(player: Squad): PlayerDetailFragment {
            val fragment = PlayerDetailFragment()
            val args = Bundle().apply {
                putString(ARG_NAME, player.name)
                putString(ARG_DOB, player.dateOfBirth)
                putString(ARG_NATIONALITY, player.nationality)
                putString(ARG_POSITION, player.position)
            }
            fragment.arguments = args
            return fragment
        }
    }
}