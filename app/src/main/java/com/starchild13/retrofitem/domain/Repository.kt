package com.starchild13.retrofitem.domain

/**
 * Repository interface defining domain data operations for retrieving quotes.
 */
interface Repository {
    /**
     * Retrieves a list of [Quote] objects either from remote data sources or fallback data.
     *
     * @return List of formatted [Quote] items.
     */
    suspend fun getQuotes(): List<Quote>
}
