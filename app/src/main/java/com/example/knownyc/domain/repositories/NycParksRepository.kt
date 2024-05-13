package com.example.knownyc.domain.repositories

import com.example.knownyc.commons.AppError
import com.example.knownyc.commons.Either
import com.example.knownyc.domain.models.Borough
import com.example.knownyc.domain.models.Park

interface NycParksRepository {
    suspend fun getNycParks(): Either<AppError, List<Park>>

}