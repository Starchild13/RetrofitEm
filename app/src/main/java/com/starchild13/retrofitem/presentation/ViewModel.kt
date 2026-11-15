package com.starchild13.retrofitem.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.starchild13.retrofitem.di.HiltModule
import com.starchild13.retrofitem.shared.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Android ViewModel managing UI state for fetching and displaying Simpsons quotes.
 * Annotated with [@HiltViewModel] for Hilt dependency injection integration.
 *
 * @param application The application context supplied to [AndroidViewModel].
 */
@HiltViewModel
class ViewModel @Inject constructor(application: Application) : AndroidViewModel(
    application
){

    /** Internal mutable state flow initialized to [State.Loading]. */
    private var _quoteState = MutableStateFlow<State>(State.Loading)

    /** Public read-only [StateFlow] observed by the UI layer. */
    val quoteState: StateFlow<State> = _quoteState.asStateFlow()

    private val retrofit = HiltModule.providesRetrofit()
    private val apiService = HiltModule.providesApiService(retrofit = retrofit)
    private val repository = HiltModule.providesRepository(apiService = apiService)

    init {
        getQuotes()
    }

    /**
     * Triggers asynchronous fetching of character quotes from the repository and updates [_quoteState].
     */
    fun getQuotes() {
        viewModelScope.launch {
            _quoteState.update { State.Loading }

            try {
                _quoteState.update { State.Success(quote = repository.getQuotes()) }
            } catch (_: Exception) {
                _quoteState.update { State.Error }
            }
        }
    }
}

