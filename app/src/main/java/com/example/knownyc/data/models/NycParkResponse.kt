package com.example.knownyc.data.models

import com.example.knownyc.commons.AppError
import com.example.knownyc.domain.models.Park
import kotlinx.serialization.Serializable

//@Serializable
@Serializable
data class NycParkResponse(
    val signname: String,
    val location: String,
    val url: String= "",
    val waterfront: Boolean? = false,
)
