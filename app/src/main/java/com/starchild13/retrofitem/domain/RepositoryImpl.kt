package com.starchild13.retrofitem.domain

import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: APIService
) : Repository {
    override suspend fun getQuotes(): List<Quote> {
        return apiService.getQuotes()
    }
}