package com.example.aichatboat

sealed interface ChatBotUiState {
    data object  Ideal : ChatBotUiState
    data object loading :ChatBotUiState
    data class Success( val ChatData: String): ChatBotUiState
    data class Error(val chatError: String) :ChatBotUiState
}