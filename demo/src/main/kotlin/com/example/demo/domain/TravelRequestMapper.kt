package com.example.demo.domain

import com.example.demo.domain.interfaces.TravelRequestInput
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
//travelResquetInput em travelRequest
@Component
class TravelRequestMapper (
    val passengerRepository:  PassengerRepository
) {
    fun map (input: TravelRequestInput) : TravelRequest {
        val passenger = passengerRepository.findById(input.passengerId)
            .orElseThrow {ResponseStatusException(HttpStatus.NOT_FOUND)}

        return TravelRequest(passenger = passenger,
        origin = input.origin,
        destination = input.destination)
    }
}