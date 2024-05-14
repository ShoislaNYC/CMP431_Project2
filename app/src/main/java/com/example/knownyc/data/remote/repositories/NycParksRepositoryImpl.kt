package com.example.knownyc.data.remote.repositories

import com.example.knownyc.commons.AppError
import com.example.knownyc.commons.Either
import com.example.knownyc.data.mappers.parksMapper
import com.example.knownyc.domain.models.Park
import com.example.knownyc.domain.repositories.NycParksRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class NycParksRepositoryImpl @Inject constructor(
    private val api: NycOpenDataApiService
) : NycParksRepository {
    private suspend fun loadDataFromAPI(borough: String): List<Park> {
        val response = api.getNycParks(borough)
        return parksMapper(response)
    }
    override suspend fun getNycParks(borough: String): Either<AppError, List<Park>> {
        return try {
            val response = loadDataFromAPI(borough)
            val parks = response.map { it }
            Either.Data(parks)
        } catch (e: IOException) {
            Either.Error(AppError("Network Error: ${e.message}"))
        } catch (e: Exception) {
            Either.Error(AppError("Unknown Error: ${e.message}"))

        }
    }
}