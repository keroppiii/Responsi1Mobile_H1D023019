package com.fatimah.responsi1mobile.network

import com.fatimah.responsi1mobile.data.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {
    @GET("v4/teams/{id}")
    fun getTeamDetails(
        @Path("id") teamId: Int,
        @Header("X-Auth-Token") apiKey: String
    ): Call<TeamResponse>
}