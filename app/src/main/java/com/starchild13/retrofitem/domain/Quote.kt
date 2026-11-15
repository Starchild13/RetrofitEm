package com.starchild13.retrofitem.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing the top-level API response containing character counts and results.
 *
 * @property count Total number of characters available in the response.
 * @property results List of [CharacterDto] items returned by the API.
 */
@Serializable
data class CharactersResponse(
    @SerialName("count") val count: Int = 0,
    @SerialName("results") val results: List<CharacterDto> = emptyList()
)

/**
 * Data transfer object representing an individual character from the network response.
 *
 * @property id Unique identifier for the character.
 * @property name Display name of the character.
 * @property phrases List of famous quotes or phrases spoken by the character.
 * @property portraitPath Relative image URL path for the character portrait.
 */
@Serializable
data class CharacterDto(
    @SerialName("id") val id: Int = 0,
    @SerialName("name") val name: String = "",
    @SerialName("phrases") val phrases: List<String> = emptyList(),
    @SerialName("portrait_path") val portraitPath: String = ""
)

/**
 * Domain model representing a formatted character quote item for display in the UI.
 *
 * @property quote The quote text spoken by the character.
 * @property character The name of the character.
 * @property image Full URL of the character portrait image.
 * @property characterDirection Layout alignment direction indicator.
 */
data class Quote(
    val quote: String,
    val character: String,
    val image: String,
    val characterDirection: String
)

