package com.fatimah.responsi1mobile.data

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

data class TeamResponse(
    val name: String?,
    val crest: String?,
    val venue: String?,
    val coach: Coach?,
    val squad: List<Squad>?
)
data class Coach(
    val name: String?,
    val dateOfBirth: String?,
    val nationality: String?
)

@Parcelize
data class Squad(
    val name: String?,
    val dateOfBirth: String?,
    val nationality: String?,
    val position: String?
): Parcelable