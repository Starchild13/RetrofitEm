package com.starchild13.retrofitem.domain

import javax.inject.Inject

/**
 * Implementation of [Repository] that fetches character quotes from [APIService]
 * with robust error handling and built-in offline fallback data.
 *
 * @property apiService The network API service used to fetch raw character data.
 */
class RepositoryImpl @Inject constructor(
    private val apiService: APIService
) : Repository {

    /**
     * Fetches quotes from the remote API, mapping character DTOs into domain [Quote] models.
     * Falls back to hardcoded sample quotes if network requests fail or return empty results.
     */
    override suspend fun getQuotes(): List<Quote> {
        return try {
            val response = apiService.getCharacters()
            response.results.map { character ->
                Quote(
                    quote = character.phrases.firstOrNull() ?: "D'oh!",
                    character = character.name,
                    image = "https://thesimpsonsapi.com${character.portraitPath}",
                    characterDirection = "Right"
                )
            }.ifEmpty { getFallbackQuotes() }
        } catch (_: Exception) {
            getFallbackQuotes()
        }
    }

    /**
     * Provides fallback sample quotes when network connectivity is unavailable or requests fail.
     */
    private fun getFallbackQuotes(): List<Quote> {
        return listOf(
            Quote(
                quote = "I hope this has taught you a lesson about modifying random food.",
                character = "Homer Simpson",
                image = "https://thesimpsonsapi.com/character/1.webp",
                characterDirection = "Right"
            ),
            Quote(
                quote = "Eat my shorts!",
                character = "Bart Simpson",
                image = "https://thesimpsonsapi.com/character/3.webp",
                characterDirection = "Left"
            ),
            Quote(
                quote = "Excellent!",
                character = "Charles Montgomery Burns",
                image = "https://thesimpsonsapi.com/character/13.webp",
                characterDirection = "Right"
            )
        )
    }
}

