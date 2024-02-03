package com.starchild13.retrofitem.shared

import com.starchild13.retrofitem.domain.Quote

sealed interface State {

    data class Success(val quote: List<Quote>): State

    data object Loading: State

    data object Error: State

}