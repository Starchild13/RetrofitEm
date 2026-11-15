package com.starchild13.retrofitem.domain

import retrofit2.http.GET

/**
 * Retrofit API service interface defining network endpoints for fetching Simpsons character data.
 */
interface APIService {
    /**
     * Fetches a list of characters and their quotes from the Simpsons API endpoint.
     *
     * @return A [CharactersResponse] containing character data records.
     */
    @GET("characters")
    suspend fun getCharacters(): CharactersResponse
}

