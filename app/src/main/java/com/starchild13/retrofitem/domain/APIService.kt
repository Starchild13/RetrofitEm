// Define the package for the class.
package com.starchild13.retrofitem.domain

// Import the GET annotation from the Retrofit library.
import retrofit2.http.GET

// Define an interface named APIService. This interface will be used to make network requests.
interface APIService {
    // Annotate the function with @GET to indicate it's a GET request.
    // The string "quotes?count=13" is the endpoint URL.
    // When this function is called, Retrofit will make a GET request to this endpoint.
    @GET("quotes?count=13")
    suspend fun getQuotes(): List<Quote> // Define a suspending function named getQuotes.
    // This function will return a List of Quote objects.
    // The suspending function can be paused and resumed at a later time, which makes it useful for operations like network requests.
    // The List<Quote> indicates that the JSON response will be converted into a list of Quote objects.
}
