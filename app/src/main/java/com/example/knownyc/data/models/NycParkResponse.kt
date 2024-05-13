package com.example.knownyc.data.models

import com.example.knownyc.commons.AppError
import com.example.knownyc.domain.models.Park

data class NycParkResponse(
    val isLoading: Boolean = false,
    val parks: List<Park> = emptyList(),
    val error: AppError? = null,
)
