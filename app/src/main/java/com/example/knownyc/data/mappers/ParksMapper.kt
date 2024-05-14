package com.example.knownyc.data.mappers

import com.example.knownyc.data.models.NycParkResponse
import com.example.knownyc.domain.models.Park
import com.example.knownyc.util.AppConstants.NYC_OPEN_DATA_API_BASE_URL

suspend fun parksMapper(
    listOfParks: List<NycParkResponse>
): List<Park> {
    val parks = mutableListOf<Park>()

    for (i in listOfParks.indices) {
        val parkList = listOfParks[i]

        val park = Park(
            signname = parkList.signname,
            location = parkList.location,
            url = parkList.url ,
            waterfront = parkList.waterfront!!,
        )
        parks.add(park)
    }
    return parks
}