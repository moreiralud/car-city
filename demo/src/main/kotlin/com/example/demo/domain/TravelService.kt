package com.example.demo.domain

import org.springframework.stereotype.Component

//salva os pedidos de viagem
@Component
class TravelSevice (
    val travelRequestRepository: TravelRequestRepository
    ){
    fun saveTravelRequest(travelRequest: TravelRequest) =
        travelRequestRepository.save(travelRequest)
}


