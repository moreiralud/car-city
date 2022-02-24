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

    fun map(travelRequest: TravelRequest) : TravelRequestOutput{
        return TravelRequestOutput(
            id = travelRequest.id!!, //apesar do campo poder ser nulo, nesse contexto ele nunca deverá estar nulo
            origin = travelRequest.origin,
            destination = travelRequest.destination,
            status = travelRequest.status,
            creationDate = travelRequest.creationDate
        )
    }
}