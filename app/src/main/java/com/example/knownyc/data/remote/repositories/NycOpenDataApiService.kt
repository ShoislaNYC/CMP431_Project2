package com.example.knownyc.data.remote.repositories

import com.example.knownyc.data.models.NycParkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NycOpenDataApiService {
    // Query: Borough
    // 'M' -> Manhattan
    // 'X' -> Bronx
    // 'Q' -> Queens
    // 'B' -> Brooklyn
    // 'R' -> Staten Island

    @GET("enfh-gkve.json")
    suspend fun getNycParks(
        @Query("borough") borough: String,
        @Query("retired") retired: Boolean = false,
    ) : List<NycParkResponse>
}