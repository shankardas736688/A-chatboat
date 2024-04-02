package com.example.aichatboat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aichatboat.components.ChatFooter
import com.example.aichatboat.components.ChatHeader
import com.example.aichatboat.components.ChatList

@Composable
fun ChatBot(
 viewModel: ChatBotvM= viewModel( )
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        ChatHeader()
        Box(modifier = Modifier.weight(1f),
          contentAlignment = Alignment.Center,
        ){
            if (viewModel.list.isEmpty()){
                Text(text = "no chat available")
            }else
        ChatList(list = viewModel.list)
        }
        ChatFooter{
            if (it.isEmpty()){
                viewModel.sendMessage(it)
            }
        }
    }

}