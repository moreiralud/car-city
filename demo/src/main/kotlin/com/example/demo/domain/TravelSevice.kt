package com.example.demo.domain

import com.example.demo.domain.interfaces.TravelRequestInput
import org.springframework.stereotype.Component

@Component
class TravelSevice (
    val travelRequestRepository: TravelRequestRepository
    ){
    fun saveTravelRequest(travelRequest: TravelRequestInput) =
        travelRequestRepository.save(travelRequest)
}


