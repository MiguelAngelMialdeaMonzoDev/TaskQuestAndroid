package com.example.data.dto

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

// Funciones de extensión útiles
suspend fun <T> Result<T>.onSuccess(action: suspend (T) -> Unit): Result<T> {
    if (this is Result.Success) {
        action(data)
    }
    return this
}

suspend fun <T> Result<T>.onError(action: suspend (Exception) -> Unit): Result<T> {
    if (this is Result.Error) {
        action(exception)
    }
    return this
}

suspend fun <T> Result<T>.onLoading(action: suspend () -> Unit): Result<T> {
    if (this is Result.Loading) {
        action()
    }
    return this
}