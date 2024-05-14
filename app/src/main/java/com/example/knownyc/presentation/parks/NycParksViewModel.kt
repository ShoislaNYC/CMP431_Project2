package com.example.knownyc.presentation.parks

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.knownyc.commons.Either
import com.example.knownyc.commons.Event
import com.example.knownyc.commons.TAG
import com.example.knownyc.commons.sendEvent
import com.example.knownyc.domain.repositories.NycParksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NycParksViewModel @Inject constructor(
    private val repository : NycParksRepository
) : ViewModel() {

    // TODO: Project 2
    // Inject nycParksRepository

    private val _state = MutableStateFlow(NycParksUIState())
    val state = _state.asStateFlow()
    private var borough = ""

    fun setBoroughCode(boroCode: String) {
        borough = boroCode
        getNycParks(borough)
    }

    init {
        Log.d(TAG, "ViewModel init: getting NYC parks")
        getNycParks(borough)
    }

    private fun getNycParks(boroughCode: String) {
        viewModelScope.launch {
            // load the data
            _state.update {
                it.copy(isLoading = true)
            }

            when (val result = repository.getNycParks(boroughCode)) {
                is Either.Data -> {
                    Log.d(TAG, "Successfully loaded parks data")
                    _state.update {
                        it.copy(
                            parks = result.value
                        )
                    }
                }

                is Either.Error -> {
                    Log.e(TAG, "Error: loading parks data")
                    _state.update {
                        it.copy(
                            error = result.error
                        )
                    }
                    sendEvent(Event.Toast(result.error.message))
                }
            }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}