package com.example.karaoke_app.Interface

import com.example.karaoke_app.top100.top100

interface OncTopClickListner {
    fun OnTopClick(item: top100, position: Int)
}