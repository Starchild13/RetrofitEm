package com.starchild13.retrofitem.shared

import com.starchild13.retrofitem.domain.Quote

/**
 * Represents the sealed UI state hierarchy for screens in the RetrofitEm application.
 */
sealed interface State {

    /**
     * Successful data fetching state containing loaded character quotes.
     *
     * @property quote List of [Quote] items returned from data repository.
     */
    data class Success(val quote: List<Quote>): State

    /**
     * Loading state indicating an asynchronous fetch operation is active.
     */
    data object Loading: State

    /**
     * Error state indicating failure during data retrieval operations.
     */
    data object Error: State

}
