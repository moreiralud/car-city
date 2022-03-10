package com.example.demo.domain

import java.time.LocalDateTime

class TravelRequestOutput (
    val id: Long,
    val origin: String,
    val destination: String,
    val status: TravelRequestStatus,
    val creationDate: LocalDateTime
)
