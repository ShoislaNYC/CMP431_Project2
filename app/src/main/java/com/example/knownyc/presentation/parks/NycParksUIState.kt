package com.example.knownyc.presentation.parks

import com.example.knownyc.commons.AppError
import com.example.knownyc.domain.models.Borough
import com.example.knownyc.domain.models.Park

data class NycParksUIState(
    val isLoading: Boolean = false,
    val parks: List<Park> = emptyList(),
    val error: AppError? = null,
)
