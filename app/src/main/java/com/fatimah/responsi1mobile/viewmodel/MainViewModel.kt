package com.fatimah.responsi1mobile.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatimah.responsi1mobile.data.TeamResponse
import com.fatimah.responsi1mobile.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _teamData = MutableLiveData<TeamResponse>()
    val teamData: LiveData<TeamResponse> = _teamData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun fetchTeamDetails(teamId: Int, apiKey: String) {
        _isLoading.value = true

        ApiClient.apiService.getTeamDetails(teamId, apiKey).enqueue(object : Callback<TeamResponse> {

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _teamData.value = response.body()
                } else {
                    _errorMessage.value = "Failed to get data: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                _isLoading.value = false // Selesai loading
                _errorMessage.value = "Network Error: ${t.message}"
                Log.e("MainViewModel", "onFailure: ", t)
            }
        })
    }
}