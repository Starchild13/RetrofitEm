package com.starchild13.retrofitem.presentation

import androidx.compose.runtime.Composable
import com.starchild13.retrofitem.shared.State

@Composable
fun StateScreen(state: State) {

    when(state) {

        is State.Error -> ErrorScreen()
        is State.Loading -> LoadingScreen()
        is State.Success -> SuccessScreen(quoteList = state.quote)

    }

}