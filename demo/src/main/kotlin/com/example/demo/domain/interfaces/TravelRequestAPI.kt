package com.example.demo.domain.interfaces

import com.example.demo.domain.TravelRequest
import com.example.demo.domain.TravelRequestMapper
import com.example.demo.domain.TravelSevice
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(path = ["/travelRequests"], produces = [MediaType.APPLICATION_JSON_VALUE])
class TravelRequestAPI(
    val travelSevice : TravelSevice
    val mapper: TravelRequestMapper
    ){

    @PostMapping
    fun makeTravelRequest(@RequestBody travelRequestInput: TravelRequestInput){
        travelSevice.saveTravelRequest(mapper.map(travelRequestInput))

    }
}

data class TravelRequestInput(
    val passengerId: Long,
    val origin : String,
    val destination: String
)

