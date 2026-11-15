package com.starchild13.retrofitem.presentation

import androidx.compose.runtime.Composable
import com.starchild13.retrofitem.shared.State

/**
 * State router composable that renders different UI screens depending on the current [State] emission.
 *
 * @param state The current UI state ([State.Loading], [State.Success], or [State.Error]).
 * @param onRetry Callback triggered when retry is requested from error state.
 */
@Composable
fun StateScreen(state: State, onRetry: () -> Unit) {

    when(state) {

        is State.Error -> ErrorScreen(onRetry = onRetry)
        is State.Loading -> LoadingScreen()
        is State.Success -> SuccessScreen(quoteList = state.quote)

    }

}
