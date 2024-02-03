// Define the package for this class.
package com.starchild13.retrofitem.presentation

// Import necessary classes and libraries.
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
import okio.IOException
import javax.inject.Inject

// Annotation to integrate ViewModel with Hilt for dependency injection.
@HiltViewModel
class ViewModel @Inject constructor(application: Application) : AndroidViewModel(
    application = application // Inherits from AndroidViewModel and receives the Application instance.
){

    // MutableStateFlow for managing the state of quotes. Initially set to State.Loading.
    private var _quoteState = MutableStateFlow<State>(State.Loading)

    // Expose an immutable StateFlow to be observed by the UI.
    val quoteState: StateFlow<State> = _quoteState.asStateFlow()

    // Create Retrofit, ApiService, and Repository instances using HiltModule.
    private val retrofit = HiltModule.providesRetrofit()
    private val apiService = HiltModule.providesApiService(retrofit = retrofit)
    private val repository = HiltModule.providesRepository(apiService = apiService)

    // Initializer block to fetch quotes when ViewModel is created.
    init {
        getQuotes()
    }

    // Function to fetch quotes from the repository.
    fun getQuotes() {
        // Launch a coroutine within the ViewModel's scope.
        viewModelScope.launch {

            // Update state to Loading before making the network request.
            _quoteState.update { State.Loading }

            try {
                // On successful network response, update state to Success with received data.
                _quoteState.update { State.Success(quote = repository.getQuotes()) }
            } catch (e: IOException) {
                // On network failure, update state to Error.
                _quoteState.update{ State.Error }
            }
        }
    }
}
