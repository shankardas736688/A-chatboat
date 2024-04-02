package com.example.aichatboat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotvM : ViewModel() {
    val list by lazy {
        mutableListOf<ChatData>()
    }
//    coroutine aata hai lazy iss liye 'by' lagaya hai
    private val genAi by lazy {
        GenerativeModel(
            modelName ="gemini-pro",
            apiKey = "AIzaSyAAT4yz0i7mih8-0NQdstfXU1-lumX0_Bg",
        )
    }
    fun sendMessage(message: String)= viewModelScope.launch {
//        var response : String?=genAi.startChat().sendMessage(prompt = message).text
        val chat:Chat= genAi.startChat()
        list.add(ChatData(message,ChatRoleEnum.USER.role))
//        Log.d("AI_ANS",response.toString())
        chat.sendMessage(
            content(ChatRoleEnum.USER.role){
                text(message)}).text?.let{
                 list.add((ChatData(it,ChatRoleEnum.MODEL.role)))
                }
            }

    }
