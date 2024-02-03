package com.starchild13.retrofitem.domain

interface Repository {
    suspend fun getQuotes(): List<Quote>
}