package com.example.aichatboat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aichatboat.ChatData
import com.example.aichatboat.ChatRoleEnum

@Composable
fun ChatList(
    list:MutableList<ChatData>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) {
            if (it.role==ChatRoleEnum.USER.role) {
                Text(text = it.message, modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .padding(12.dp),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            } else {
               Text (
                    text = it.message, modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .padding(12.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

//@Composable
//fun Text(text: Any, modifier: Modifier, color: Color, fontSize: TextUnit, fontWeight: FontWeight) {
//    // Your custom text implementation goes here
//}
